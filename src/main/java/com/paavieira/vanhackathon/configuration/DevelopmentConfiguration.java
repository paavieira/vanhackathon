package com.paavieira.vanhackathon.configuration;

import java.util.Arrays;

import com.paavieira.vanhackathon.location.Location;
import com.paavieira.vanhackathon.location.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;

@Configuration
@Profile("development")
public class DevelopmentConfiguration {

	@Autowired
	private LocationRepository locationRepository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		final Location home = new Location("-33.867591", "151.201196");

		Arrays.asList(home).forEach(location -> {
			if (!locationRepository.exists(Example.of(location))) {
				locationRepository.save(location);
			}
		});

	}

}