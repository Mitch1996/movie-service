package com.netflix.Netflix.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

	@GetMapping(value = "/all")
	private String getStudentString()
	{
	    String uri = "https://api.themoviedb.org/3/movie/550?api_key=48be4332df8912d896ba3e7762604d5f";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    return result; 
	}
}