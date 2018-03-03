package filterPictures

//import junit.framework.TestCase
import junit.framework.TestCase
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File




// https://blog.philipphauer.de/best-practices-unit-testing-kotlin/
// http://putridparrot.com/blog/unit-testing-your-kotlin-code/

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExtractPictureMetaDataTest : TestCase(){
    @Test
    fun testgetMetaData() {
        //
        // val myFile7 = "C:\\Users\\edlei\\Documents\\ExportTest"

        val resourcesDirectory = File("src/main/resources")
        val myFile7 = resourcesDirectory.absolutePath + "/ExportTest"
        System.out.println(myFile7)
        val e = ExtractPictureMetaData()
        assertEquals(36, e.readFiles(myFile7))
        System.out.println("test")
    }
}