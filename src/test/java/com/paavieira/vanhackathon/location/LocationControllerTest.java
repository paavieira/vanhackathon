package com.paavieira.vanhackathon.location;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
@WebMvcTest(LocationController.class)
public class LocationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LocationService locationService;

	@Test
	public void getNearby_ShouldReturnLocation() throws Exception {
		final Location home = new Location("-34.397", "150.644");
		final Location work = new Location("-34.397", "150.644");
		final List<Location> locations = Arrays.asList(home, work);

		given(locationService.findAll())
			.willReturn(locations);

		mockMvc.perform(get("/locations"))
			.andExpect(status().isOk())
			// .andExpect(content().json(locations))
			;			
	}
    

}