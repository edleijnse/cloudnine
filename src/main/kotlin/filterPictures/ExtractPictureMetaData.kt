package filterPictures

import com.drew.imaging.ImageMetadataReader
import com.drew.imaging.ImageProcessingException
import com.drew.metadata.Metadata
import java.io.File
import java.io.IOException

class ExtractPictureMetaData {

    internal fun getMetaData(file: File): String {
        // https://drewnoakes.com/code/exif/
        var myMetadata = ""
        var metadata: Metadata?
        try {
            metadata = ImageMetadataReader.readMetadata(file)

            var delimitor = ""
            if (metadata != null) {
                metadata.directories.forEach { directory ->
                    directory.tags.forEach { tag ->
                        myMetadata += delimitor + tag.tagName + "=" + tag.description
                        delimitor = ","
                    }
                    if (directory.hasErrors()) {
                        directory.errors.forEach { error -> System.err.format("ERROR: %s", error) }
                    }
                }
            }

        } catch (e: ImageProcessingException) {
            // e.printStackTrace();
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return myMetadata
    }

    internal fun readFiles(myFile2: String): Int {
        var selectedFiles = 0
        File(myFile2).walk().forEach {
            if (it.isFile) {
                val fileName = it.absoluteFile.name
                if ((fileName.toLowerCase().endsWith(".cr2")) || (fileName.toLowerCase().endsWith(".jpg"))) {
                    println(it)
                    val myMetadata = getMetaData(it)
                    println(myMetadata)
                    selectedFiles++
                }

            }
        }
        return selectedFiles
    }

}
