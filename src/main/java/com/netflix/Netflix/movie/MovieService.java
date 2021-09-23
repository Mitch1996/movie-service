package com.netflix.Netflix.movie;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MovieDb", url = "${serviceURL}")
public interface MovieService {
//  disney movies api =   "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_companies=6125&with_watch_monetization_types=flatrate"
    @RequestMapping(value = "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&with_companies={with_companies}&primary_release_year={year}&with_genres={genre}&with_watch_monetization_types=flatrate" , method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> discovery(
            @PathVariable("sort") String sort,
            @PathVariable("include_vid") String include_vid,
            @PathVariable("page") Integer page,
            @PathVariable("year") Integer year,
            @PathVariable("genre") String genre);


    @RequestMapping(value = "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&with_companies={with_companies}&primary_release_year={year}&with_watch_monetization_types=flatrate" , method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> Disney(
            @PathVariable("sort") String sort,
            @PathVariable("include_vid") String include_vid,
            @PathVariable("page") Integer page,
            @PathVariable("year") Integer year,
            @PathVariable("with_companies") String with_companies);


}



