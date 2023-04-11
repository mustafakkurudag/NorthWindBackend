package com.example.northwindbackend.dto;

public class AddressDTO {

    private String city;
    private String district;
    private String neighborhood;
    private String street;

    public AddressDTO() {}

    public AddressDTO(String city, String district, String neighborhood, String street) {
        this.city = city;
        this.district = district;
        this.neighborhood = neighborhood;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
