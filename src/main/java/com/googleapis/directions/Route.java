package com.googleapis.directions;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Route {

    private List<Leg> legs = new ArrayList<Leg>();

    /**
     * @return the legs
     */
    public List<Leg> getLegs() {
        return legs;
    }

    /**
     * @param legs the legs to set
     */
    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }
    
    @JsonIgnore
    public void addLeg(Leg leg) {
        this.legs.add(leg);
    }

}