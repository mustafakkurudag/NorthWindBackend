package com.example.northwindbackend.repository;

import com.example.northwindbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT TOP(50) c.CustomerID, c.CompanyName, c.ContactName, c.City FROM dbo.Customers c", nativeQuery = true)
    List<Customer> getFiftyCustomers();
}
