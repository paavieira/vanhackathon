package com.googleapis.directions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String lat;
    private String lng;

    public Location(){}

    public Location(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }
    
    /**
     * @return the lat
     */
    public String getLat() {
        return lat;
    }
    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
        this.lat = lat;
    }
    /**
     * @return the lng
     */
    public String getLng() {
        return lng;
    }
    /**
     * @param lng the lng to set
     */
    public void setLng(String lng) {
        this.lng = lng;
    }
}