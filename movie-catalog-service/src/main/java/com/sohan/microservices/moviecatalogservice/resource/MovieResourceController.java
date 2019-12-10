package com.sohan.microservices.moviecatalogservice.resource;

import com.sohan.microservices.moviecatalogservice.model.CatalogItems;
import com.sohan.microservices.moviecatalogservice.model.UserRating;
import com.sohan.microservices.moviecatalogservice.services.RatingService;
import com.sohan.microservices.moviecatalogservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieResourceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieService movieService;

    @Autowired
    private RatingService ratingService;

    @RequestMapping("/{userId}")
    public List<CatalogItems> getCatalog(@PathVariable("userId") String userId)
    {
        UserRating userRating = ratingService.getUserRating(userId);

        return userRating.getUserRatings()
                .stream().map(movieService::getCatalogItems)
                .collect(Collectors.toList());
    }

    /*MovieInfo movieInfo = webClientBuilder.build()
        .get()
        .uri("http://localhost:8081/movies/" + rating.getMovieId())
        .retrieve()
        .bodyToMono(MovieInfo.class)
        .block();*/

}
