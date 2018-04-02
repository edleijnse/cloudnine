package filterPictures

//import junit.framework.TestCase
import com.thoughtworks.xstream.XStream
import junit.framework.TestCase
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;
import java.io.File




// https://blog.philipphauer.de/best-practices-unit-testing-kotlin/
// http://putridparrot.com/blog/unit-testing-your-kotlin-code/

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExtractPictureMetaDataTest : TestCase(){
    @Test
    fun testReadData() {
        //
        // val myFile7 = "C:\\Users\\edlei\\Documents\\ExportTest"

        val resourcesDirectory = File("src/main/resources")
        val myFile7 = resourcesDirectory.absolutePath + "/ExportTest"
        System.out.println(myFile7)
        val e = ExtractPictureMetaData()
        assertEquals(36, e.readFiles(myFile7))
        System.out.println("test")
    }
    @Test
    fun testCreateCsvFile() {

        val resourcesDirectory = File("src/main/resources")
        val startsWithDirectory = resourcesDirectory.absolutePath + "/ExportTest"
        val writeInCsvFile = resourcesDirectory.absolutePath + "/CsvFile"
        System.out.println(startsWithDirectory)
        val e = ExtractPictureMetaData()
        assertEquals(36, e.createCsVFile(startsWithDirectory,writeInCsvFile))
        System.out.println("test")
    }

    @Test
    fun testGetMetaDataIntoString(){
        val myFile = File("src/main/resources/ExportTest/famromano-100.jpg")
        val e = ExtractPictureMetaData()
        val output = e.getMetaDataIntoString(myFile)
        assertTrue(output.length>10)
        System.out.println("output: " + output)
    }

    @Test
    fun testGetMetaDataInto(){
        val myFile = File("src/main/resources/ExportTest/famromano-100.jpg")
        val e = ExtractPictureMetaData()
        val output = e.getPictureMetaData(myFile)
        var xStream = XStream()
        System.out.println(xStream.toXML(output))

        assertEquals("Canon EOS 6D",output.model)
        assertEquals("Canon",output.make)
        assertEquals("2017:11:12 10:15:55",output.dateTime)
    }
}