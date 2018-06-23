package com.paavieira.vanhackathon.restaurant;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/nearby/{lat}/{lng}")
	@ResponseBody
	public List<Restaurant> getNearby(@PathVariable("lat") String lat, @PathVariable("lng") String lng) {
		return restaurantService.findNearby(lat, lng);
	}


}