package com.sohan.microservices.ratingsdataservice.model;

import java.util.List;

public class UserRating {
    List<Rating> userRatings;

    public UserRating() {
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
