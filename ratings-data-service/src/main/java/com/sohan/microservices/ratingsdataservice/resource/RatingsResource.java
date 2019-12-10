package com.sohan.microservices.ratingsdataservice.resource;

import com.sohan.microservices.ratingsdataservice.model.Rating;
import com.sohan.microservices.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ratingsdata")
@RestController
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId)
    {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUesrRating(@PathVariable("userId") String userId)
    {
        List<Rating> ratings = Arrays.asList(
                new Rating("101", 3),
                new Rating("203", 3)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRatings(ratings);

        return userRating;
    }


}
