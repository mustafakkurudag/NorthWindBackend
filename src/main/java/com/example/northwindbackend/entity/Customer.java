package com.example.northwindbackend.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "CustomerID", updatable = false)
    private String customerId;

    @Column(name = "companyname", updatable = false)
    private String companyName;

    @Column(name = "contactname", updatable = false)
    private String contactName;

    @Column(name = "City", updatable = false)
    private String city;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
