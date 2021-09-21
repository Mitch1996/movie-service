package com.netflix.Netflix.movie;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MovieDb", url = "${serviceURL}")
public interface MovieService {

    @RequestMapping(value = "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&primary_release_year={year}&with_genres={genre}&with_watch_monetization_types=flatrate" , method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> dicovery(
            @PathVariable("sort") String sort,
            @PathVariable("include_vid") String include_vid,
            @PathVariable("page") Integer page,
            @PathVariable("year") Integer year,
            @PathVariable("genre") String genre);

}



