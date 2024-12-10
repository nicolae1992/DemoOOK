package appenginex.com.demoook.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import appenginex.com.demoook.data.paging.PostCardPagingSource
import appenginex.com.demoook.domain.usecase.GetContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getContentUseCase: GetContentUseCase
) : ViewModel() {

    val postsFlow = Pager(
        config = PagingConfig(
            pageSize = 30,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { PostCardPagingSource(getContentUseCase) }
    ).flow.cachedIn(viewModelScope)

}