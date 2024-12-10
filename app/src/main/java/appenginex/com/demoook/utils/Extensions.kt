package appenginex.com.demoook.utils

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.imageBoxStyle(cornerRadius: Dp = 1.dp): Modifier =
    this
        .fillMaxWidth()
        .aspectRatio(1.3f)
        .clip(RoundedCornerShape(cornerRadius))