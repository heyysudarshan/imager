package imager.frontend.shared.service

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.UIKit.*
import platform.darwin.NSObject
import platform.posix.memcpy
import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalForeignApi::class, ExperimentalNativeApi::class)
internal actual fun requestImage(
    onPhotoPicked: (ByteArray) -> Unit,
    onPhotoPickerError: () -> Unit
) {
    val picker = UIImagePickerController().apply {
        sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary
        allowsEditing = false
    }

    picker.delegate = object : NSObject(), UIImagePickerControllerDelegateProtocol,
        UINavigationControllerDelegateProtocol {

        override fun imagePickerController(
            picker: UIImagePickerController,
            didFinishPickingMediaWithInfo: Map<Any?, *>
        ) {
            val image =
                didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage] as? UIImage
            val imageData: NSData? = image?.let { UIImageJPEGRepresentation(it, 1.0) }
            if (imageData != null) {
                val byteArray = ByteArray(imageData.length.toInt())
                byteArray.usePinned {
                    memcpy(it.addressOf(0), imageData.bytes, imageData.length)
                }
                onPhotoPicked(byteArray)
            } else {
                onPhotoPickerError()
            }
            picker.dismissViewControllerAnimated(true, completion = null)
        }

        override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
            onPhotoPickerError()
            picker.dismissViewControllerAnimated(true, completion = null)
        }
    }

    val rootController = UIApplication.sharedApplication
        .keyWindow
        ?.rootViewController

    rootController?.presentViewController(
        picker,
        animated = true,
        completion = null
    )
}