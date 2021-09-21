package com.netflix.Netflix.movie;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MovieDb", url = "${serviceURL}", path = "movie")
public interface MovieService {

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> findById(@PathVariable Integer id, @RequestParam("api_key") String apiKey);
<<<<<<< HEAD

    @GetMapping(value = "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&primary_release_year={year}&&with_genres={genre}&with_watch_monetization_types=flatrate")
    ResponseEntity<String> dicovery(
            @PathVariable("sort") String sort,
            @PathVariable("include_vid") String include_vid,
            @PathVariable("page") Integer page,
            @PathVariable("year") Integer year,
            @PathVariable("genre") String genre);


    @GetMapping(value = "genre/movie/list?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US")
    ResponseEntity<String> genre();
}



=======
}

>>>>>>> parent of 6e22ec2 (Discover Endpoint with feign , MVC testing setup)
