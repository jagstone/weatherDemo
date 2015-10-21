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
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

/**
 *
 * @author john.stone571
 */
public class YahooParser {
    private static Logger log = Logger.getLogger(YahooParser.class);

  public Weather parse(InputStream inputStream) throws Exception {
    Weather weather = new Weather();

    log.info( "Creating XML Reader" );
    SAXReader xmlReader = createXmlReader();
    Document doc = xmlReader.read( inputStream );

    log.info( "Parsing XML Response" );
    weather.setCity(
      doc.valueOf("/rss/channel/y:location/@city") );
    weather.setRegion(
      doc.valueOf("/rss/channel/y:location/@region") );
    weather.setCountry(
      doc.valueOf("/rss/channel/y:location/@country") );
    weather.setCondition(
      doc.valueOf("/rss/channel/item/y:condition/@text") );
    weather.setTemp(
      doc.valueOf("/rss/channel/item/y:condition/@temp") );
    weather.setChill(
      doc.valueOf("/rss/channel/y:wind/@chill") );
    weather.setHumidity(
      doc.valueOf("/rss/channel/y:atmosphere/@humidity") );

    return weather;
  }

  private SAXReader createXmlReader() {
    Map<String,String> uris = new HashMap<String,String>();
    uris.put( "y", "http://xml.weather.yahoo.com/ns/rss/1.0" );

    DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs( uris );

    SAXReader xmlReader = new SAXReader();
      xmlReader.setDocumentFactory( factory );
    return xmlReader;
  }
}
