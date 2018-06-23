package com.paavieira.vanhackathon.location;

import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    private LocationService locationService;

    @Before
    public void setUp() throws Exception {
        this.locationService = new LocationService(locationRepository);
    }

    @Test
    public void findAll_shouldReturnLocations() throws Exception {
        final Location home = new Location("-34.397", "150.644");
        final Location work = new Location("-34.397", "150.644");
        final List<Location> locations = Arrays.asList(home, work);

        given(locationRepository.findAll()).willReturn(locations);

        final List<Location> actualLocations = locationService.findAll();
        Assertions.assertThat(actualLocations.size()).isEqualTo(2);
    }

}