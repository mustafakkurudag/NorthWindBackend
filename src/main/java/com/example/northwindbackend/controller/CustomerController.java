package com.example.northwindbackend.controller;

import com.example.northwindbackend.entity.Customer;
import com.example.northwindbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerController() {}

    @GetMapping("/get/customers")
    public List<Customer> show50Customers() {
        return customerService.getFiftyCustomers();
    }

}
