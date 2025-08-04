package imager.frontend.shared.service

internal class ImageRequestorService {
    fun getImageFromUserDevice(): ByteArray {
        return requestImage()
    }
}