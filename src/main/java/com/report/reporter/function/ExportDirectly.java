/*
  i-net software provides programming examples for illustration only, without warranty
  either expressed or implied, including, but not limited to, the implied warranties
  of merchantability and/or fitness for a particular purpose. This programming example
  assumes that you are familiar with the programming language being demonstrated and
  the tools used to create and debug procedures. i-net software support professionals
  can help explain the functionality of a particular procedure, but they will not modify
  these examples to provide added functionality or construct procedures to meet your
  specific needs.
  © i-net software 1998-2015
*/

package com.report.reporter.function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * This sample shows how simple it is to take advantage of a running i-net Clear Reports server. Using the report URL
 * property "init", you can have a report returned to you directly in the format you specify. Possible "init" values
 * are:
 * <ul>
 * <li>pdf
 * <li>txt
 * <li>html
 * <li>xls
 * <li>rtf
 * <li>svg
 * <li>ps
 * <li>ps2
 * <li>ps3
 * <li>csv
 * <li>data
 * <li>xml
 * </ul>
 * See <a
 * href="https://www.inetsoftware.de/documentation/clear-reports/plugins/clear-reports/documentation/en/report-url-parameters">i-net Clear
 * Reports documentation</a> for further URL parameters.
 */
@Component
@Slf4j
public class ExportDirectly {

    

    /**
     * Exports a report using report URL property "init".
     * @throws IOException if an error occurred
     */
    public static void export() throws IOException {
    	System.out.println("test~~~~~");
        URL url = new URL( "/?report=file:c:/report.rpt&init=pdf" );
        // See: https://www.inetsoftware.de/documentation/clear-reports/plugins/clear-reports/documentation/en/report-url-parameters
        // for further URL parameters

        URLConnection conn = url.openConnection();
        conn.connect();
        InputStream in = conn.getInputStream();
        FileOutputStream out = new FileOutputStream( new File( "c:/tmp/output.pdf" ) );
        byte[] buf = new byte[1024];
        int length;
        while( (length = in.read( buf )) > 0 ) {
            out.write( buf, 0, length );
        }
        in.close();
        out.close();
        System.exit( 0 );
    }

    /**
     * Main method of this sample
     * @param args arguments not used
     * @throws IOException if an error occurred
     */
    public static void main( String[] args ) throws IOException {
        ExportDirectly.export();
    }
}
