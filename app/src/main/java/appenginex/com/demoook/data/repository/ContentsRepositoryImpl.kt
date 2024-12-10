package appenginex.com.demoook.data.repository

import appenginex.com.demoook.data.remote.ApiConstants.ApiParams.PARAM_DEFAULT_PER_PAGE
import appenginex.com.demoook.data.remote.BaseApiResponse
import appenginex.com.demoook.data.remote.NetworkService
import appenginex.com.demoook.data.remote.Resource
import appenginex.com.demoook.di.IoDispatcher
import appenginex.com.demoook.domain.models.ItemCard
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContentsRepositoryImpl @Inject constructor(
    private val serviceAPI: NetworkService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ContentsRepository, BaseApiResponse() {

    override fun getContent(page: Int, perPage: Int?): Flow<Resource<ItemCard>> {
        return flow {
            emit(safeApiCall { serviceAPI.getContents(page = page, limit = perPage ?: PARAM_DEFAULT_PER_PAGE) })
        }.flowOn(ioDispatcher)
    }
}