package imager.frontend.shared.service

internal object ImageRequestorService {
    fun getImageFromUserDevice(): ByteArray {
        return requestImage()
    }
}