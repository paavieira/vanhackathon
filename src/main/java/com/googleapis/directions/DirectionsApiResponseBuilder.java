package com.googleapis.directions;

public class DirectionsApiResponseBuilder {
    
    private final DirectionsApiResponse response = new DirectionsApiResponse();
    
    public DirectionsApiResponseBuilder withStep(Location startLocation, Location endLocation, String instructions) {
        final Route route = new Route();
        final Leg leg = new Leg();
        final Step step = new Step(startLocation, endLocation, instructions);
        leg.addStep(step);
        route.addLeg(leg);
        response.addRoute(route);
        return this;
    }

    public DirectionsApiResponse build() {
        return this.response;
    }

}

