package com.paavieira.vanhackathon.route;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.tools.DiagnosticCollector;

import com.googleapis.directions.DirectionsApiResponse;
import com.googleapis.directions.DirectionsApiResponseBuilder;
import com.paavieira.vanhackathon.location.Location;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class RouteServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Spy
    private RouteService routeService;

    @Test
    public void findRoutes_ShouldReturnRoutes() throws Exception {
        final String origLat = "34.1330949";
        final String origLng = "-118.3524442";

        final String destLat = "33.8098177";
        final String destLng = "-117.9154353";

        final com.googleapis.directions.Location origLocation = new com.googleapis.directions.Location(origLat, origLng);
        final com.googleapis.directions.Location destLocation = new com.googleapis.directions.Location(destLat, destLng);
        final DirectionsApiResponse response = new DirectionsApiResponseBuilder()
                .withStep(origLocation, destLocation, "Take a left.").build();

        given(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).willReturn(response);

        List<Route> routes = routeService.findRoutes(origLat, origLng, destLat, destLng);
        assertThat(routes.size()).isEqualTo(1);
        assertThat(routes.get(0).getStart().getLat()).isEqualTo("34.1330949");
        assertThat(routes.get(0).getStart().getLng()).isEqualTo("-118.3524442");
        assertThat(routes.get(0).getEnd().getLat()).isEqualTo("33.8098177");
        assertThat(routes.get(0).getEnd().getLng()).isEqualTo("-117.9154353");
        assertThat(routes.get(0).getDescription()).isEqualTo("Take a left.");

    }

}