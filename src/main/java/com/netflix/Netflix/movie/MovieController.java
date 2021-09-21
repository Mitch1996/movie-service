package com.netflix.Netflix.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class MovieController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${serviceURL}")
    String serviceURL;

    @Autowired
    MovieService movieService;

    @Value("${apiKey}")
    String apiKey;

    @GetMapping("/full")
    String getMovie() {
        return restTemplate.getForObject(serviceURL + "movie/550?api_key=" + apiKey, String.class);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<String> getMovieInfo(@PathVariable("movieId") Integer movieId) {
        return movieService.findById(movieId, apiKey);
    }

<<<<<<< HEAD
    @GetMapping("discovery/{sort}/{include_vid}/{page}/{year}/{genre}")
    public ResponseEntity<String> getDiscoverInfo( @PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page , @PathVariable("year") Integer year, @PathVariable("genre") String genre) {
        return movieService.dicovery(sort, include_vid, page, year, genre);
    }
=======
    @RequestMapping("/discover")
    String getDiscoverMovie() {
        String moviesToDiscover = restTemplate.getForObject(serviceURL + "discover/movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate", String.class);
        return moviesToDiscover;

>>>>>>> parent of 6e22ec2 (Discover Endpoint with feign , MVC testing setup)

    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}