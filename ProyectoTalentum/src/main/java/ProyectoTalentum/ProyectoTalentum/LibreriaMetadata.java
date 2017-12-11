package ProyectoTalentum.ProyectoTalentum;

/*
 * Copyright 2002-2017 Drew Noakes
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 * More information about this project is available at:
 *
 *    https://drewnoakes.com/code/exif/
 *    https://github.com/drewnoakes/metadata-extractor
 */

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import com.drew.metadata.iptc.IptcReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Showcases the most popular ways of using the metadata-extractor library.
 * <p>
 * For more information, see the project wiki: https://github.com/drewnoakes/metadata-extractor/wiki/GettingStarted
 *
 * @author Drew Noakes https://drewnoakes.com
 */
public class LibreriaMetadata
{
    public static void main(String[] args)
    {
        File file = new File("src/resources/prueba.jpg");
        //
        // UNKNOWN FILE TYPE
        //
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

         //   print(metadata, "Using ImageMetadataReader");
            printDate(metadata);
            printGPS(metadata);
        } catch (ImageProcessingException e) {
            print(e);
        } catch (IOException e) {
            print(e);
        }

    }

    /**
     * Write all extracted values to stdout.
     */
    
    
    
    private static void print(Metadata metadata, String method)
    {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.print(' ');
        System.out.print(method);
        System.out.println("-------------------------------------------------");
        System.out.println();

        //
        // A Metadata object contains multiple Directory objects
        //
        for (Directory directory : metadata.getDirectories()) {

            //
            // Each Directory stores values in Tag objects
            //
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
            }

            //
            // Each Directory may also contain error messages
            //
            for (String error : directory.getErrors()) {
                System.err.println("ERROR: " + error);
            }
        }
    }
    
    private static void printDate(Metadata metadata)
    {
    	
    	// obtain the Exif directory
    	ExifSubIFDDirectory directory
    	    = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

    	// query the tag's value
    	Date date
    	    = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        System.out.println(date);

    	
    }
    
    private static void printGPS(Metadata metadata)
    {
    	
    	// obtain the Exif directory
    	
    	GpsDirectory directory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
    	
    	GeoLocation gpsPrueba = directory.getGeoLocation();
    	// query the tag's value
        System.out.println(gpsPrueba);

    	
    }

    private static void print(Exception exception)
    {
        System.err.println("EXCEPTION: " + exception);
    }
}