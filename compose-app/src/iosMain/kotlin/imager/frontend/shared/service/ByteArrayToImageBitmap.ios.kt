package imager.frontend.shared.service

import androidx.compose.ui.graphics.ImageBitmap
import platform.UIKit.UIImage

internal actual fun byArrayToImageBitmap(image: ByteArray): ImageBitmap {
    val nsData = byteArray.toNSData()
    val uiImage = UIImage(data = nsData) ?: error("Failed to decode image")
    return uiImage.toImageBitmap()
}