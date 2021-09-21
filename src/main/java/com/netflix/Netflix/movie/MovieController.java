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

    @GetMapping("/{movieId}")
    public ResponseEntity<String> getMovieInfo(@PathVariable("movieId") Integer movieId) {
        return movieService.findById(movieId, apiKey);
    }

    @GetMapping("discovery/{sort}/{include_vid}/{page}/{year}/{genre}")
    public ResponseEntity<String> getDiscoverInfo( @PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page , @PathVariable("year") Integer year, @PathVariable("genre") String genre) {
        return movieService.dicovery(sort, include_vid, page, year, genre);
    }

    @GetMapping("genre")
    public ResponseEntity<String> genre() {
        return movieService.genre();
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}