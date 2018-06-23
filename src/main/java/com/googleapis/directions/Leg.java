package com.googleapis.directions;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Leg {

    private List<Step> steps = new ArrayList<Step>();

    /**
     * @return the steps
     */
    public List<Step> getSteps() {
        return steps;
    }
    /**
     * @param steps the steps to set
     */
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @JsonIgnore
    public void addStep(Step step) {
        this.steps.add(step);
    }
    
}