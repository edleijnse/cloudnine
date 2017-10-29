package filterPictures

import java.io.File

/**
 * Kotlin Example to traverse directory and its contents
 * https://www.tutorialkart.com/kotlin/iterate-through-all-files-in-a-directory-using-kotlin-example/
 */
fun main(args: Array<String>) {

    // using extension function walk
    val extractMetaData = ExtractMetaData();
    val myFile1 = "C:\\Users\\edlei\\Pictures\\In Lightroom CC gespeicherte Fotos\\Luzerner Marathon 2017 JPEG"
    val myFile2 = "C:\\Users\\edlei\\Pictures\\In Lightroom CC gespeicherte Fotos\\Luzerner Marathon 2017"
    val myFile3 = "C:\\Users\\edlei\\Pictures\\Streetphotography\\2017-09-30"
    File(myFile2).walk().forEach {
        if (it.isFile) {
            val fileName = it.absoluteFile.name
            if ((fileName.endsWith(".CR2")) || (fileName.endsWith(".jpg"))){
                println(it)
                val myMetadata = extractMetaData.getMetaData(it)
                println(myMetadata)
            }

        }
    }
}
