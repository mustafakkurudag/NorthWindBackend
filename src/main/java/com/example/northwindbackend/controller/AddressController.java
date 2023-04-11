package com.example.northwindbackend.controller;

import com.example.northwindbackend.dto.AddressDTO;
import com.example.northwindbackend.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    private AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/index")
    public String index() {
        return "address index";
    }

    @PostMapping("/add")
    public AddressDTO addAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.addAddress(addressDTO);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public AddressDTO getAddress(@PathVariable("id") Long id) {
        return addressService.getAddress(id);
    }

    @GetMapping("/get/all")
    @ResponseBody
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public AddressDTO updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
        return addressService.updateAddress(id, addressDTO);
    }
}
