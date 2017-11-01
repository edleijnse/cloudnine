package filterPictures

import java.io.File

/**
 * Kotlin Example to traverse directory and its contents
 * https://www.tutorialkart.com/kotlin/iterate-through-all-files-in-a-directory-using-kotlin-example/
 */
fun main(args: Array<String>) {


    val myFile1 = "C:\\Users\\edlei\\Pictures\\In Lightroom CC gespeicherte Fotos\\Luzerner Marathon 2017 JPEG"
    val myFile2 = "C:\\Users\\edlei\\Pictures\\In Lightroom CC gespeicherte Fotos\\Luzerner Marathon 2017"
    val myFile3 = "C:\\Users\\edlei\\Pictures\\Streetphotography\\2017-09-30"
    val myFile4 = "C:\\Users\\edlei\\Pictures\\export"
    val myFile5 = "Z:\\Lightroom"
    val myFile6 = "C:\\Users\\edlei\\OneDrive\\Dokumente"

    // alternativ 1 instantiate class
    val extractPictureMetaData = ExtractPictureMetaData();
    val fileCount = extractPictureMetaData.readFiles(myFile4)

    // alternativ 2 direct use without primary instantiation
    val fileCount2 = ExtractPictureMetaData().readFiles(myFile4)
    println ("selected files: " + fileCount)

}
