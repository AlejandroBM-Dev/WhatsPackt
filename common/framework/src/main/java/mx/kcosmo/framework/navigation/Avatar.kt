package mx.kcosmo.framework.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage

@Suppress("ktlint:standard:function-naming")
@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageUrl: String,
    size: Dp,
    contentDescription: String? = "User avatar",
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier =
            modifier
                .size(size)
                .clip(CircleShape),
        contentScale = ContentScale.Crop,
    )
}
