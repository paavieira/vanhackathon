package com.paavieira.vanhackathon.route;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routes")
public class RouteController {

	private RouteService routeService;

	public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

	@GetMapping("/from/{origLat}/{origLng}/to/{destLat}/{destLng}")
	@ResponseBody
	public List<Route> get(
		@PathVariable("origLat") String origLat, 
		@PathVariable("origLng") String origLng, 
		@PathVariable("destLat") String destLat,
		@PathVariable("destLng") String destLng
	) {
		return routeService.findRoutes(origLat, origLng, destLat, destLng);
	}

}