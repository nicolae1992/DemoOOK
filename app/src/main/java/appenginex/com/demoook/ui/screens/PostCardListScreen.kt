package appenginex.com.demoook.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import appenginex.com.demoook.ui.components.ErrorMessage
import appenginex.com.demoook.ui.components.LoaderIndicator
import appenginex.com.demoook.ui.components.PostCardItem

@Composable
fun PostCardListScreen(viewModel: MainViewModel = hiltViewModel()) {
    val lazyPagingItems = viewModel.postsFlow.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(lazyPagingItems.itemCount) { post ->
                lazyPagingItems[post]?.let {
                    PostCardItem(post = it)
                }
            }
        }

        if (lazyPagingItems.loadState.refresh is LoadState.Loading) {
            LoaderIndicator()
        }

        if (lazyPagingItems.loadState.append is LoadState.Loading) {
            LoaderIndicator(modifier = Modifier.align(Alignment.BottomCenter))
        }

        if (lazyPagingItems.loadState.append is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            )
        }

        if (lazyPagingItems.loadState.refresh is LoadState.Error) {
            val error = lazyPagingItems.loadState.refresh as LoadState.Error
            ErrorMessage(
                message = error.error.localizedMessage ?: "Unknown error",
                onRetry = { lazyPagingItems.retry() }
            )
        }

    }
}