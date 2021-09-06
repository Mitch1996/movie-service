package com.netflix.Netflix.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

	@Autowired
	RestTemplate restTemplate;

	@Value("${serviceURL}")
	String serviceURL;

	@Value("${apiKey}")
	String apiKey;

	@GetMapping("/all")
	String getAvailableOperations() {
		return restTemplate.getForObject(serviceURL + "/movie/550?api_key=" + apiKey, String.class);
	}

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
}