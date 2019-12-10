package com.sohan.microservices.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sohan.microservices.moviecatalogservice.model.CatalogItems;
import com.sohan.microservices.moviecatalogservice.model.MovieInfo;
import com.sohan.microservices.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItems")
    public CatalogItems getCatalogItems(Rating rating) {
            MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), MovieInfo.class);
                    return new CatalogItems(movieInfo.getMovieName(), "Test Description", rating.getRating());

    }

    public CatalogItems getFallbackCatalogItems(Rating rating) {
        return new CatalogItems("Fallback Movie Name", "", -1);
    }
}
