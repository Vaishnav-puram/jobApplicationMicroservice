package com.microservices.reviewservice.service;


import com.microservices.reviewservice.model.Review;
import com.microservices.reviewservice.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepo reviewRepo;
    @Override
    public List<Review> getReviews(Long cId) {
        return reviewRepo.findByCompanyId(cId);
    }

    @Override
    public void addReview(Long cId, Review review) {
        review.setCompanyId(cId);
        reviewRepo.save(review);
    }

    @Override
    public Review getReview(Long rId) {
        return reviewRepo.findById(rId).orElseThrow();
    }

    @Override
    public void updateReview(Long rId, Review newReview) {
        Review review=reviewRepo.findById(rId).orElseThrow();
        review.setRating(newReview.getRating());
        review.setCompanyId(newReview.getCompanyId());
        review.setTitle(newReview.getTitle());
        reviewRepo.save(review);
    }

    @Override
    public void deleteReview(Long rId) {
        reviewRepo.deleteById(rId);
    }
}
