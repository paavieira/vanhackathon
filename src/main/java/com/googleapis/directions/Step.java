package com.googleapis.directions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Step {

    @JsonProperty(value = "start_location")
    private Location startLocation;

    @JsonProperty(value = "end_location")
    private Location endLocation;

    @JsonProperty(value = "html_instructions")
    private String instructions;

    public Step(){}

    public Step(Location startLocation, Location endLocation, String instructions) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.instructions = instructions;
    }

    /**
     * @return the startLocation
     */
    public Location getStartLocation() {
        return startLocation;
    }
    /**
     * @param startLocation the startLocation to set
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }
    /**
     * @return the endLocation
     */
    public Location getEndLocation() {
        return endLocation;
    }
    /**
     * @param endLocation the endLocation to set
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
    /**
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }
    /**
     * @param instructions the instructions to set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}