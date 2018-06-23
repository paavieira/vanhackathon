package com.paavieira.vanhackathon.restaurant;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RestaurantService restaurantService;

    @Test
    public void getNearby_shouldReturnRestaurants() throws Exception {
        final String lat = "33.867591";
        final String lng = "51.201196";
        final String name = "Australian Cruise Group";
        final List<Restaurant> restaurants = Arrays.asList(new Restaurant(lat, lng, name));

        given(restaurantService.findNearby(lat, lng)).willReturn(restaurants);

        mockMvc.perform(get("/restaurants/nearby/-33.867591/151.201196"))
			.andExpect(status().isOk());
    }

}