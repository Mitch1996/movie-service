package com.netflix.Netflix.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @GetMapping("discovery/{sort}/{include_vid}/{page}/{year}")
    public ResponseEntity<String> getDiscoverInfo(@PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page, @PathVariable("year") Integer year) {
        return movieService.discoveryYear(sort, include_vid, page, year);
    }


    @GetMapping("discovery/{sort}/{include_vid}/{page}/{year}/{genre}")
    public ResponseEntity<String> getDiscoverInfo(@PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page, @PathVariable("year") Integer year, @PathVariable("genre") String genre
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


        return movieService.discovery(sort, include_vid, page, year, genre);
    }


    @GetMapping("discovery/{sort}/{include_vid}/{page}/{genre}")
    public ResponseEntity<String> getDiscoverInfoGenre(@PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid, @PathVariable("page") Integer page, @PathVariable("genre") String genre) {
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


        return movieService.discoveryGenre(sort, include_vid, page, genre);
    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<String> getMovieVideos(@PathVariable("movie_id") Integer movie_id) {
        return movieService.MovieVideos(movie_id);
    }
///{page}/{year}
//@PathVariable("page") Integer page, @PathVariable("year") Integer year
    @GetMapping("discovery/disney/{sort}/{include_vid}/{with_companies}")
    public ResponseEntity<String> getDisneyMovies(@PathVariable("sort") String sort, @PathVariable("include_vid") String include_vid,  @PathVariable("with_companies") String with_companies
    ) {
        if (with_companies.equals("disney")) {
            with_companies = "6125";
            System.out.println(with_companies);
        } else {
            System.out.println("error movie company not found");
        }
        return movieService.Disney(sort, include_vid,  with_companies);
    }


//    http://api.themoviedb.org/3/discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&with_cast=62

    @GetMapping("/cast/{castID}")
    public ResponseEntity<String> GetMoviesOfActor(@PathVariable("castID") String castID) {

        switch (castID) {
            case "brucewilles":
                castID = "62";
                break;
            case "arnoldschwarzenegger":
                castID = "1100";
                break;
            case "jacknicholson":
                castID = "514";
                break;
            case "keanureeves":
                castID = "6384";
                break;
            case "denzelwashington":
                castID = "5292";
                break;
            case "alpacino":
                castID = "1158";
                break;
            case "ryanreynolds":
                castID = "10859";
                break;
            case "dwaynejohnson":
                castID = "18918";
                break;
            case "adamsandler":
                castID = "19292";
                break;
            case "willsmith":
                castID = "2888";
                break;
            case "jackiechan":
                castID = "18897";
                break;
            case "scarlettjohansson":
                castID = "1245";
                break;
            case "galgadot":
                castID = "90633";
                break;
            case "markwahlberg":
                castID = "13240";
                break;

            default:
                System.out.println("actor not found");
                break;

        }
        return movieService.actorMovies(castID);
    }

    @RequestMapping("/search/movie/{movieName}")
    public ResponseEntity<String> searchMovies(@PathVariable("movieName") String movieName) {
        return movieService.findMovie(movieName);
    }

    @RequestMapping("/search/person/{nameActor}")
    public ResponseEntity<String> searchActor(@PathVariable("nameActor") String nameActor) {
        return movieService.findMovieOfActor(nameActor);
    }


    @RequestMapping("/genre/movie/list")
    String getGenres() {
        String movieGenres = restTemplate.getForObject("https://api.themoviedb.org/3/genre/movie/list?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US", String.class);
        return movieGenres;
    }


    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}