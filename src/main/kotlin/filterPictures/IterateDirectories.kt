package filterPictures

import java.io.File

/**
 * Kotlin Example to traverse directory and its contents
 * https://www.tutorialkart.com/kotlin/iterate-through-all-files-in-a-directory-using-kotlin-example/
 */
fun main(args: Array<String>) {

    // using extension function walk
    val extractMetaData = ExtractMetaData();
    File("C:\\Users\\edlei\\Pictures\\Streetphotography\\2017-09-30").walk().forEach {
        println(it)
        println("isFile: " + it.isFile)
        if (it.isFile) {
            println("isFile")
            val myMetadata = extractMetaData.getMetaData(it)
            println(myMetadata)
        }
    }
}
