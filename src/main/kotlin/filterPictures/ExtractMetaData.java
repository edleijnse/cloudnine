package filterPictures;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExtractMetaData {

String getMetaData(File file) {
    // https://drewnoakes.com/code/exif/
    String myMetadata = "";
    Metadata metadata = null;
    try {
        metadata = ImageMetadataReader.readMetadata(file);
        ExifSubIFDDirectory exifSubIFDDirectory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        myMetadata +=  exifSubIFDDirectory.getName() + " "  + DateUtilities.INSTANCE.toISO8601UTC(exifSubIFDDirectory.getDateDigitized());
       //  myMetadata = metadata.toString();
    } catch (ImageProcessingException e) {
        // e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return myMetadata;
}

}
