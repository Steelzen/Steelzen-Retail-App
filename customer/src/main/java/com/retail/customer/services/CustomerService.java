package com.retail.customer.services;

import com.retail.customer.entities.Customer;
import com.retail.customer.repositories.CustomerRepository;
import com.retail.customer.requests.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void registerCustomer (CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phone(request.phone())
                .build();

        customerRepository.saveAndFlush(customer);
    }

    public List<Customer> getCustomer () { return this.customerRepository.findAll(); }
}
