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
    public ResponseEntity<String> getDiscoverInfo( @PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page, @PathVariable("year") Integer year, @PathVariable("genre") String genre) {

        switch (genre) {
            case "Action":
                genre = "28";
                break;
            case "Adventure":
                genre = "12";
                break;
            case "Animation":
                genre = "16";
                break;
            case "Comedy":
                genre = "35";
                break;
            case "Crime":
                genre = "80";
                break;
            case "Documentary":
                genre = "99";
                break;
            case "Drama":
                genre = "18";
                break;
            case "Family":
                genre = "10751";
                break;
            case "Fantasy":
                genre = "14";
                break;
            case "History":
                genre = "36";
                break;
            case "Horror":
                genre = "27";
                break;
            case "Music":
                genre = "10402";
                break;
            case "Mystery":
                genre = "9648";
                break;
            case "Romance":
                genre = "10749";
                break;
            case "Science_Fiction":
                genre = "878";
                break;
            case "TV_Movie":
                genre = "10770";
                break;
            case "Thriller":
                genre = "53";
                break;
            case "War":
                genre = "10752";
                break;
            case "Western":
                genre = "37";
                break;
        }

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