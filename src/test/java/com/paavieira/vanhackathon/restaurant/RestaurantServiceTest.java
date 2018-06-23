package com.paavieira.vanhackathon.restaurant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;

import com.googleapis.places.PlacesApiResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)

public class RestaurantServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Spy
    private RestaurantService restaurantService;

    @Test
	public void findNearby_ShouldReturnNearbyRestaurants() throws Exception {
        final String lat = "-33.8670522";
        final String lng = "151.1957362";

        PlacesApiResponse response = new PlacesApiResponse(); // TODO: mock response

		given(restTemplate.getForObject(Mockito.anyString(), Mockito.any()))
            .willReturn(response);

        final List<Restaurant> restaurants = restaurantService.findNearby(lat, lng);
        assertThat(restaurants.size()).isEqualTo(1);
	}

}