package com.paavieira.vanhackathon.route;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.paavieira.vanhackathon.location.Location;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteController.class)
public class RouteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RouteService routeService;

	@Test
	public void get_ShouldReturnRoutes() throws Exception {
		final String origLat = "34.1330949";
		final String origLng = "-118.3524442";
		final Location orig = new Location(origLat, origLng);

		final String destLat = "33.8098177";
		final String destLng = "-117.9154353";
		final Location dest = new Location(destLat, destLng);

		final List<Route> routes = Arrays.asList(new Route(orig, dest, "Take a left over there."));
		given(routeService.findRoutes(origLat, origLng, destLat, destLng)).willReturn(routes);
		
		final String jsonContent = "[{\"start\":{\"latitude\":\"34.1330949\",\"longitude\":\"-118.3524442\"},\"end\":{\"latitude\":\"33.8098177\",\"longitude\":\"-117.9154353\"},\"description\":\"Take a left over there.\"}]";
		mockMvc.perform(get("/routes/from/34.1330949/-118.3524442/to/33.8098177/-117.9154353"))
			.andExpect(status().isOk())
			.andExpect(content().json(jsonContent));
	}

}