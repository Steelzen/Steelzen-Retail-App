package com.retail.customer;

import com.retail.customer.entities.Customer;
import com.retail.customer.entities.Review;
import com.retail.customer.requests.CustomerRegistrationRequest;
import com.retail.customer.requests.ReviewRegistrationRequest;
import com.retail.customer.services.CustomerService;
import com.retail.customer.services.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
