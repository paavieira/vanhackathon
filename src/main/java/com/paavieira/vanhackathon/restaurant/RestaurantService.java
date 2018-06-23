package com.paavieira.vanhackathon.restaurant;

import java.util.List;
import java.util.stream.Collectors;

import com.googleapis.places.Geometry;
import com.googleapis.places.Location;
import com.googleapis.places.PlacesApiResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestaurantService {

    @Value("${googleapis.key}")
    private String googleApiKey;

    @Value("${googleapis.places.baseUrl}")
    private String placesApi;

    RestTemplate restTemplate = new RestTemplate();

    public List<Restaurant> findNearby(String lat, String lng) {
        final String url = String.format(placesApi, lat, lng, googleApiKey);
        final PlacesApiResponse response = restTemplate.getForObject(url, PlacesApiResponse.class);
        return parseResponse(response);
    }
    
    private List<Restaurant> parseResponse(PlacesApiResponse response) {
        return response.getResults().stream().map(result -> {
            final Geometry geometry = result.getGeometry();
            final Location location = geometry.getLocation();
            final String lat = location.getLat();
            final String lng = location.getLng();
            final String name = result.getName();
            return new Restaurant(lat, lng, name);
        }).collect(Collectors.toList());        
    }

}