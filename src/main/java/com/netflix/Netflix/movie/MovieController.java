package com.netflix.Netflix.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//import static com.netflix.Netflix.movie.MovieService.with_companies;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${serviceURL}")
    String serviceURL;

    @Autowired
    MovieService movieService;

    @Value("${apiKey}")
    String apiKey;
//    "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&with_companies={with_companies}&primary_release_year={year}&with_genres={genre}&with_watch_monetization_types=flatrate" , method = RequestMethod.GET)


    @GetMapping("discovery/{sort}/{include_vid}/{page}/{year}/{genre}")
    public ResponseEntity<String> getDiscoverInfo( @PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page, @PathVariable("year") Integer year ,  @PathVariable("genre") String genre
    ) {
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


        return movieService.discovery(sort, include_vid, page, year,genre);
    }

    @GetMapping("discovery/disney/{sort}/{include_vid}/{page}/{year}/{with_companies}")
    public ResponseEntity<String> getDisneyMovies( @PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page, @PathVariable("year") Integer year , @PathVariable("with_companies") String with_companies
    ) {
        if (with_companies.equals("disney")){
            with_companies = "6125";
            System.out.println(with_companies);
        }else{
            System.out.println("error movie company not found");
        }
        return movieService.Disney(sort, include_vid, page, year,with_companies);
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