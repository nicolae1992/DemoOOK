package appenginex.com.demoook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import appenginex.com.demoook.data.remote.ApiConstants.IMAGE_BASE_URL
import appenginex.com.demoook.domain.models.Postcard
import appenginex.com.demoook.utils.imageBoxStyle

@Composable
fun PostCardItem(post: Postcard) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ImageLoader(
            itemModifier = Modifier.imageBoxStyle(),
            imageUrl = IMAGE_BASE_URL.plus(post.image),
            contentScale = ContentScale.Crop,
        )
        if (post.hasGif) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.8f))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "GIF",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }

}

