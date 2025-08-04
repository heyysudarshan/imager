package imager.frontend.shared.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

internal fun Modifier.backgroundContainerModifier(): Modifier {
    return this
        .background(color = Color.White)
        .fillMaxSize()
}

internal fun Modifier.profileImageModifier(): Modifier {
    return this
        .clip(shape = RoundedCornerShape(size = 1000.dp))
        .height(height = 200.dp)
        .width(width = 200.dp)
}