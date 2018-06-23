package com.paavieira.vanhackathon.location;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location findById(String id) {
        try {
            return locationRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new LocationNotFoundException();
        }
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

}