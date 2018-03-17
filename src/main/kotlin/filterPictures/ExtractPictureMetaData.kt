package filterPictures

import com.drew.imaging.ImageMetadataReader
import com.drew.imaging.ImageProcessingException
import com.drew.metadata.Metadata
import java.io.File
import java.io.IOException

class ExtractPictureMetaData {

    internal fun getMetaDataIntoString(file: File): String {
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

    internal fun getPictureMetaData(file: File): PictureMetaData {
        // https://drewnoakes.com/code/exif/
        var myPictureMetaData: PictureMetaData = PictureMetaData()

        myPictureMetaData.make = "SAMPLE Canon XX"
        myPictureMetaData.model = "SAMPLE Canon EOS 6D XX"
        myPictureMetaData.dateTime = "SAMPLE " +
                "2017:11:12 10:15:59 XX"
        var metadata: Metadata?
        try {
            metadata = ImageMetadataReader.readMetadata(file)
            myPictureMetaData.pictureName = file.name
            myPictureMetaData.absolutePath = file.absolutePath
            myPictureMetaData.canonicalPath = file.canonicalPath

            if (metadata != null) {
                metadata.directories.forEach { directory ->
                    directory.tags.forEach({ it ->
                        if (it.tagName == "Make") {
                            myPictureMetaData.make = it.description
                        } else if (it.tagName == "Model") {
                            myPictureMetaData.model = it.description
                        } else if (it.tagName == "Lens Model") {
                            myPictureMetaData.lenseModel == it.description
                        } else if (it.tagName == "Date/Time") {
                            myPictureMetaData.dateTime = it.description
                        } else if (it.tagName == "Image Height") {
                            myPictureMetaData.height = it.description.replace("pixels", "").trim().toInt()
                        } else if (it.tagName == "Image Width") {
                            myPictureMetaData.width = it.description.replace("pixels", "").trim().toInt()
                        } else if (it.tagName == "ISO Speed Ratings"){
                            myPictureMetaData.iso = it.description.trim().toInt()
                        } else if (it.tagName == "Shutter Speed Value"){
                            myPictureMetaData.exposure = it.description
                        } else if (it.tagName == "Aperture Value"){
                            myPictureMetaData.aperture = it.description
                        } else if (it.tagName == "Exposure Bias Value"){
                            myPictureMetaData.exposureBias = it.description
                        } else if (it.tagName == "Focal Length"){
                            myPictureMetaData.focalLength = it.description
                        }
                    })
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

        return myPictureMetaData
    }


    internal fun readFiles(myFile2: String): Int {
        var selectedFiles = 0
        File(myFile2).walk().forEach {
            if (it.isFile) {
                val fileName = it.absoluteFile.name
                if ((fileName.toLowerCase().endsWith(".cr2")) || (fileName.toLowerCase().endsWith(".jpg"))) {
                    println(it)
                    val myMetadata = getMetaDataIntoString(it)
                    println(myMetadata)
                    selectedFiles++
                }

            }
        }
        return selectedFiles
    }

}
