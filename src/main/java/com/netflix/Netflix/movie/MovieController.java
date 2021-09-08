package com.netflix.Netflix.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	RestTemplate restTemplate;

	@Value("${serviceURL}")
	String serviceURL;

	@Value("${apiKey}")
	String apiKey;

	@GetMapping("/all")
	String getMovie() {
		return restTemplate.getForObject(serviceURL + "/movie/550?api_key=" + apiKey, String.class);
	}

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

	}
	@RequestMapping("/discover")
	String getDiscoverMovie() {
		String moviesToDiscover = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate"
, String.class);
		return moviesToDiscover;


	}

	@RequestMapping("/discover")
	String getDiscoverMovieAscending() {
		String moviesToDiscover = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate"
				, String.class);
		return moviesToDiscover;


	}








	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
}