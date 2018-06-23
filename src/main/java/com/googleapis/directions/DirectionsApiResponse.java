package com.googleapis.directions;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsApiResponse {
    
    private List<Route> routes = new ArrayList<Route>();

    /**
     * @return the routes
     */
    public List<Route> getRoutes() {
        return routes;
    }
    /**
     * @param routes the routes to set
     */
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
    
    @JsonIgnore
    public void addRoute(Route route) {
        this.routes.add(route);
    }

}

