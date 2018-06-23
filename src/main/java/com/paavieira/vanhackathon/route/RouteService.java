package com.paavieira.vanhackathon.route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.googleapis.directions.DirectionsApiResponse;
import com.paavieira.vanhackathon.location.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RouteService {

    @Value("${googleapis.key}")
    private String googleApiKey;

    @Value("${googleapis.directions.baseUrl}")
    private String directionsApi;
    
    RestTemplate restTemplate = new RestTemplate();

    public List<Route> findRoutes(String origLat, String origLng, String destLat, String destLng) {
        final String origin = String.format("%s, %s", origLat, origLng);
        final String destination = String.format("%s, %s", destLat, destLng);
        final String url = String.format(directionsApi, origin, destination, googleApiKey);
        final DirectionsApiResponse response = restTemplate.getForObject(url, DirectionsApiResponse.class);
        return parseResponse(response);
    }

    private List<Route> parseResponse(DirectionsApiResponse response) {
        final List<Route> routes = new ArrayList<Route>();
        response.getRoutes().forEach(route -> {
            route.getLegs().forEach(leg -> {
                routes.addAll(
                    leg.getSteps().stream().map(step -> {
                        final Location start = new Location(step.getStartLocation().getLat(), step.getStartLocation().getLng());
                        final Location end = new Location(step.getEndLocation().getLat(), step.getEndLocation().getLng());
                        final String instruction = step.getInstructions();
                        return new Route(start, end, instruction);
                    }).collect(Collectors.toList())
                );
            });
        });
        return routes;
    }

}