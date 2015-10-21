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

import junit.framework.TestCase;

import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.YahooParser;

public class YahooParserTest extends TestCase {

    public YahooParserTest(String name) {
        super(name);
    }

    public void testParser() throws Exception {
        InputStream nyData = getClass().getClassLoader()
          .getResourceAsStream("ny-weather.xml");
        Weather weather = new YahooParser().parse( nyData );
        assertEquals( "New York", weather.getCity() );
        assertEquals( "NY", weather.getRegion() );
        assertEquals( "US", weather.getCountry() );
        assertEquals( "39", weather.getTemp() );
        assertEquals( "Fair", weather.getCondition() );
        assertEquals( "39", weather.getChill() );
        assertEquals( "67", weather.getHumidity() );
    }
}
