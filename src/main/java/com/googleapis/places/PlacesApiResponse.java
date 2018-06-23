package com.googleapis.places;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlacesApiResponse {
    
    private List<Result> results;

    /**
     * @return the results
     */
    public List<Result> getResults() {
        return results;
    }
    /**
     * @param results the results to set
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }
}

