/*
 * Copyright 2015 Sonatype.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author john.stone571
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // Configure Log4J
        PropertyConfigurator
          .configure(Main.class.getClassLoader()
                      .getResource("log4j.properties"));

        // Read the zip code from the command line
        // (if none supplied, use 60202)
        String zipcode = "60202";
        try {
            zipcode = args[0];
        } catch( Exception e ) {}

        // Start the program
        new Main(zipcode).start();
    }

    private String zip;

    public Main(String zip) {
        this.zip = zip;
    }

    public void start() throws Exception {
        // Retrieve Data
        InputStream dataIn = new YahooRetriever().retrieve( zip );

        // Parse Data
        Weather weather = new YahooParser().parse( dataIn );

        // Format (Print) Data
        System.out.print( new WeatherFormatter().format( weather ) );
    }
}
