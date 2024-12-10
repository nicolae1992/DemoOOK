package appenginex.com.demoook.ui.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.gif.GifDecoder
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.svg.SvgDecoder


@Composable
fun ImageLoader(itemModifier: Modifier, imageUrl: String, contentScale: ContentScale) {
    val context = LocalContext.current
    val request = ImageRequest.Builder(context)
        .data(imageUrl)
        .crossfade(true)
        .decoderFactory(GifDecoder.Factory())
        // .decoderFactory(WebPDecoder.Factory())
        .decoderFactory(SvgDecoder.Factory())
        .listener(
            onError = { err, throwable ->
                Log.e("Coil", "Image loading error: ${throwable.throwable.message}")
            }
        )
        .build()
    AsyncImage(
        model = request,
        contentDescription = null,
        modifier = itemModifier,
        contentScale = contentScale
    )
}