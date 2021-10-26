package com.netflix.Netflix.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MovieDb", url = "${serviceURL}")
public interface MovieService {



    @RequestMapping(value = "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&primary_release_year={year}&with_genres={genre}&with_watch_monetization_types=flatrate", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> discovery(
            @PathVariable("sort") String sort,
            @PathVariable("include_vid") String include_vid,
            @PathVariable("page") Integer page,
            @PathVariable("year") Integer year,
            @PathVariable("genre") String genre);


    @RequestMapping(value = "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&with_companies={with_companies}&primary_release_year={year}&with_watch_monetization_types=flatrate", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> Disney(
            @PathVariable("sort") String sort,
            @PathVariable("include_vid") String include_vid,
            @PathVariable("with_companies") String with_companies
    );

//https://api.themoviedb.org/3/movie/300/videos?api_key=48be4332df8912d896ba3e7762604d5f&language=en-US
    @RequestMapping(value = "movie/{movie_id}/videos?api_key=48be4332df8912d896ba3e7762604d5f&language=en-US", method = RequestMethod.GET)
    ResponseEntity<String> MovieVideos(@PathVariable("movie_id") Integer movie_id);

    @RequestMapping(value = "person/{castID}/movie_credits?api_key=97d7b8e2bab65af96c47f53519958733", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> actorMovies(
            @PathVariable("castID") String with_companies);


    @RequestMapping(value = "search/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&query={movieName}&page=1&include_adult=false", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> findMovie(
            @PathVariable("movieName") String movieName);


    @RequestMapping(value = "search/person?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&query={actorName}&page=1&include_adult=false", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> findMovieOfActor(
            @PathVariable("actorName") String nameActor);


    @RequestMapping(value = "movie/{movie_id}?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US" , method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<String> findMovieDuration(
            @PathVariable("movie_id") Integer movie_id);







}