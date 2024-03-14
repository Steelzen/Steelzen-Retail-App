package com.retail.customer.services;

import com.retail.customer.entities.Customer;
import com.retail.customer.entities.Review;
import com.retail.customer.repositories.CustomerRepository;
import com.retail.customer.repositories.ReviewRepository;
import com.retail.customer.requests.ReviewRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;

    public void registerReview (ReviewRegistrationRequest request) {
        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Review review = Review.builder()
                .grade(request.grade())
                .detail(request.detail())
                .imgURL(request.imgURL())
                .productId(request.productId())
                .customer(customer)
                .build();

        reviewRepository.saveAndFlush(review);
    }

    public List<Review> getReview () { return this.reviewRepository.findAll(); }

    public Optional<Review> getReviewById (Long reviewId) {
        return this.reviewRepository.findById(reviewId);
    }
}
