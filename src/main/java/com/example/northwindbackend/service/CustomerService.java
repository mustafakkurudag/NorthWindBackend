package com.example.northwindbackend.service;

import com.example.northwindbackend.entity.Customer;
import com.example.northwindbackend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getFiftyCustomers() {
        return customerRepository.getFiftyCustomers();
    }
}
