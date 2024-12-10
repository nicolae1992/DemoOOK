package appenginex.com.demoook.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import appenginex.com.demoook.data.remote.ApiConstants.ApiParams.PARAM_DEFAULT_PER_PAGE
import appenginex.com.demoook.data.remote.Resource
import appenginex.com.demoook.domain.models.Postcard
import appenginex.com.demoook.domain.usecase.GetContentUseCase
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class PostCardPagingSource @Inject constructor(
    private val getContentUseCase: GetContentUseCase
) : PagingSource<Int, Postcard>() {
    override fun getRefreshKey(state: PagingState<Int, Postcard>): Int? =
        state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Postcard> {
        return try {
            val page = params.key ?: 1
            //val pageSize = params.loadSize
            val pageSize = minOf(params.loadSize, PARAM_DEFAULT_PER_PAGE)
            when (val resource = getContentUseCase(page, pageSize).firstOrNull()) {
                is Resource.Success -> {
                    val data = resource.data?.postcards ?: emptyList()
                    LoadResult.Page(
                        data = data,
                        prevKey = if (page == 1) null else page - 1,
                        nextKey = if (data.isEmpty()) null else page + 1
                    )
                }
                is Resource.Error -> {
                    LoadResult.Error(Exception(resource.message))
                }
                else -> {
                    LoadResult.Error(Exception("Unknown error occurred"))
                }
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}