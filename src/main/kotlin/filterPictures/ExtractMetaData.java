package filterPictures;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.thoughtworks.xstream.XStream;

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

        String delimitor = "";
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
              /*  System.out.println();
                System.out.format("[%s] - %s = %s",
                        directory.getName(), tag.getTagName(), tag.getDescription());*/
                myMetadata +=  delimitor + tag.getTagName() + "=" + tag.getDescription();
                delimitor = ",";
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }

        }
        ExifSubIFDDirectory exifSubIFDDirectory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        myMetadata +=  exifSubIFDDirectory.getName() + " "  + DateUtilities.INSTANCE.toISO8601UTC(exifSubIFDDirectory.getDateDigitized());
       //  myMetadata = metadata.toString();
        // XStream xstream = new XStream();
        //System.out.println("exifSubIfDDirectory:" + xstream.toXML(exifSubIFDDirectory));
    } catch (ImageProcessingException e) {
        // e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return myMetadata;
}

}
