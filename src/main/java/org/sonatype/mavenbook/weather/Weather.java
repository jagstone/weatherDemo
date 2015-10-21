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

/**
 *
 * @author john.stone571
 */
public class Weather {
    private String city;
    private String region;
    private String country;
    private String condition;
    private String temp;
    private String chill;
    private String humidity;

    public Weather() {}

    public String getCity() { return city; }
    public void setCity(String city) {
      this.city = city;
    }

    public String getRegion() { return region; }
    public void setRegion(String region) {
      this.region = region;
    }

    public String getCountry() { return country; }
    public void setCountry(String country) {
      this.country = country;
    }

    public String getCondition() { return condition; }
    public void setCondition(String condition) {
      this.condition = condition;
    }

    public String getTemp() { return temp; }
    public void setTemp(String temp) {
      this.temp = temp;
    }

    public String getChill() { return chill; }
    public void setChill(String chill) {
      this.chill = chill;
    }

    public String getHumidity() { return humidity; }
    public void setHumidity(String humidity) {
      this.humidity = humidity;
    }
}
