package com.microservices.reviewservice.controller;

import com.microservices.reviewservice.model.Review;
import com.microservices.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping
    public List<Review> getAllReviews(@RequestParam Long cId){
        return reviewService.getReviews(cId);
    }
    @PostMapping
    public void addReview(@RequestParam Long cId,@RequestBody Review review){
        reviewService.addReview(cId,review);
    }
    @GetMapping("/{rId}")
    public Review getReview(@PathVariable Long rId){
        return reviewService.getReview(rId);
    }
    @PutMapping("/{rId}")
    public void updateReview(@PathVariable Long rId,@RequestBody Review review){
        reviewService.updateReview(rId,review);
    }
    @DeleteMapping("/{rId}")
    public void deleteReview(@PathVariable Long rId) {
        reviewService.deleteReview(rId);
    }
}
