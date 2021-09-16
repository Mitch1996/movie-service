package com.netflix.Netflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class NetflixApplicationTest extends NetflixApplicationTestConfig {

    @Test
    public void getDiscovery() throws Exception {
        String uri = "https://api.themoviedb.org/3/genre/movie/list?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US";
        MvcResult mvcResult = (MvcResult) mvc.perform(MockMvcRequestBuilders.get(uri));
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }
}
