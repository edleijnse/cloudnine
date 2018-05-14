package startStatistics

import filterPictures.ExtractPictureMetaData
import java.io.File

/**
 * Created by edleijnse on 13.08.17.
 * https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#package
 * Command line:
 * java -Dfile.encoding=UTF-8 -jar /Users/edleijnse/IdeaProjects/cloudnine/out/artifacts/kotlinsample_jar/kotlinsample.jar
 */
fun main(args: Array<String>) {
    println("Hello, world, Ed!")
    val resourcesDirectory = File("/Volumes/MyDrive01")
    val startsWithDirectory = resourcesDirectory.absolutePath + "/Lightroom"
    val writeInCsvFile = resourcesDirectory.absolutePath + "/MyLightroom.csv"
    System.out.println(startsWithDirectory)
    val e = ExtractPictureMetaData().createCsVFile(startsWithDirectory,writeInCsvFile)
    System.out.println("done")
}