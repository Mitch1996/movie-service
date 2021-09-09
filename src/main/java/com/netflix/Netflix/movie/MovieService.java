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
}

