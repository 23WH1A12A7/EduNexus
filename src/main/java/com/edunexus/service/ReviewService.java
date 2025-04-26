package com.edunexus.service;

import com.edunexus.model.Review;
import com.edunexus.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review submitReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsForUser(Long reviewedUserId) {
        return reviewRepository.findByReviewedUserId(reviewedUserId);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
