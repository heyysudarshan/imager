package imager.frontend.shared.service

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

internal actual fun byArrayToImageBitmap(image: ByteArray): ImageBitmap {
    val bitmap = BitmapFactory.decodeByteArray(image, 0, image.size)
    return bitmap.asImageBitmap()
}