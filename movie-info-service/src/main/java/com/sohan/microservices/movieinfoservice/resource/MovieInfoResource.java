package com.sohan.microservices.movieinfoservice.resource;

import com.sohan.microservices.movieinfoservice.model.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId)
    {
        return new MovieInfo(movieId, "Avengers");
    }

}
