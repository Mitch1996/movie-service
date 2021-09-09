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

    @RequestMapping("/discover")
    String getDiscoverMovie() {
        String moviesToDiscover = restTemplate.getForObject(serviceURL + "discover/movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate", String.class);
        return moviesToDiscover;


    }
    @RequestMapping("/genre/movie/list")
    String getGenres() {
        String movieGenres = restTemplate.getForObject("https://api.themoviedb.org/3/genre/movie/list?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US",String.class);
        return movieGenres;


    }



    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}