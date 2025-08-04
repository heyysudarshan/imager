package imager.backend.app

import imager.backend.app.domain.model.request.Body
import imager.backend.app.domain.model.response.Response
import imager.backend.app.domain.model.response.ResponseMessage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

@RestController
@SpringBootApplication
class BackendApplication {

    private val uploadDir = "uploads"

    @PostMapping("/upload")
    fun uploadImage(
        @RequestBody body: Body?,
        @RequestHeader("Image-Type") imageType: String,
    ): Response {

        if (body == null) {
            return Response(
                status = "Failed",
                message = ResponseMessage(
                    message = "Failed",
                    statusCode = 400
                )
            )
        }

        return Response(
            status = "Failed",
            message = ResponseMessage(
                message = body.image,
                statusCode = 400
            )
        )


    }
}

fun main(arguments: Array<String>) {
    runApplication<BackendApplication>(*arguments)
}