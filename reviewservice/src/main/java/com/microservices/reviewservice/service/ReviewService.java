package com.microservices.reviewservice.service;


import com.microservices.reviewservice.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(Long cId);
    void addReview(Long cId,Review review);
    Review getReview(Long rId);
    void updateReview(Long rId,Review review);
    void deleteReview(Long rId);

}
