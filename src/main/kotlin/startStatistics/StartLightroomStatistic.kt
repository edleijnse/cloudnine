package startStatistics

import filterPictures.ExtractPictureMetaData
import java.io.File

/**
 * Created by edleijnse on 13.08.17.
 * https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html#package
 * Command line:
 * java -Dfile.encoding=UTF-8 -jar /Users/edleijnse/IdeaProjects/cloudnine/out/artifacts/kotlinsample_jar/kotlinsample.jar
 * "C:\Program Files\Java\jdk1.8.0_141\bin\java.exe" -Dfile.encoding=windows-1252 -jar C:\Users\edlei\IdeaProjects\cloudnine\out\artifacts\cloudnine_jar\cloudnine.jar T: "\Fotos Tini 85" \cloudnine.csv
 *
 */
fun main(args: Array<String>) {
    println("argument 1: " + args[0])
    println("argument 2: " + args[1])
    println("argument 3: " + args[2])
    val myResourcesDirectory = args[0]
    val myStartswithDirectory = args[1]
    val myCsvFile = args[2]
    println("start!")
    // val resourcesDirectory = File("/Volumes/MyDrive01")
    val resourcesDirectory = File(myResourcesDirectory)
    // val startsWithDirectory = resourcesDirectory.absolutePath + "/Lightroom"
    val startsWithDirectory = resourcesDirectory.absolutePath + myStartswithDirectory
    // val writeInCsvFile = resourcesDirectory.absolutePath + "/MyLightroom.csv"
    val writeInCsvFile = resourcesDirectory.absolutePath + myCsvFile
    System.out.println(startsWithDirectory)
    val e = ExtractPictureMetaData().createCsVFile(startsWithDirectory,writeInCsvFile)
    System.out.println("done")
}