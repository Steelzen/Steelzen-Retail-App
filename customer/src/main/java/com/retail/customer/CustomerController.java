package com.retail.customer;

import com.retail.customer.entities.Customer;
import com.retail.customer.entities.Review;
import com.retail.customer.requests.CustomerRegistrationRequest;
import com.retail.customer.requests.ReviewRegistrationRequest;
import com.retail.customer.services.CustomerService;
import com.retail.customer.services.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ReviewService reviewService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @PostMapping("/review")
    public void registerReview(@RequestBody ReviewRegistrationRequest reviewRegistrationRequest) {
        log.info("new review registration {}", reviewRegistrationRequest);
        reviewService.registerReview(reviewRegistrationRequest);
    }

    @GetMapping
    public List<Customer> getCustomer() { return customerService.getCustomer(); }

    @GetMapping("/review")
    public List<Review> getReview() { return reviewService.getReview(); }

    @GetMapping(path = "{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long customerId) throws EntityTypeException {
        Optional<Customer> customerOptional = customerService.getCustomerById(customerId);
        if(customerOptional.isPresent()) {
            return customerOptional.get();
        }
        else {
            throw new EntityNotFoundException("Customer not found with id: " + customerId);
        }
    }

    @GetMapping(path = "/review/{reviewId}")
    public Review getReviewById (@PathVariable("reviewId") Long reviewId) throws EntityTypeException {
        Optional<Review> reviewOptional = reviewService.getReviewById(reviewId);
        if(reviewOptional.isPresent()) {
            return reviewOptional.get();
        }
        else {
            throw new EntityNotFoundException("Review not found with id: " + reviewId);
        }
    }
}
