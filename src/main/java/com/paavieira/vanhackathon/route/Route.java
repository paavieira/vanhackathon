package com.paavieira.vanhackathon.route;

import com.paavieira.vanhackathon.location.Location;

public class Route {

    private Location start;
    private Location end;
    private String description;

    public Route() {}

    public Route(Location start, Location end, String description) {
        this.start = start;
        this.end = end;
        this.description = description;
    }

    /**
     * @return the start
     */
    public Location getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Location start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Location getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Location end) {
        this.end = end;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


}