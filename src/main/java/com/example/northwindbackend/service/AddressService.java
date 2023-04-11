package com.example.northwindbackend.service;

import com.example.northwindbackend.dto.AddressDTO;
import com.example.northwindbackend.entity.Address;
import com.example.northwindbackend.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService (AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO getAddress(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            AddressDTO addressDTO = convertEntityToDto(optionalAddress.get());
            return addressDTO;
        } else {
            return null;
        }
    }

    public List<AddressDTO> getAllAddresses() {
        List<Address> addressList = addressRepository.findAll();
        List<AddressDTO> addressDTOS = new ArrayList<>();

        for (Address a :
                addressList) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO = convertEntityToDto(a);
            addressDTOS.add(addressDTO);
        }

        return addressDTOS;
    }

    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address address = convertDtoToEntity(addressDTO);
        addressRepository.save(address);

        return convertEntityToDto(address);
    }

    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();

            address.setCity(addressDTO.getCity());
            address.setDistrict(addressDTO.getDistrict());
            address.setNeighborhood(addressDTO.getNeighborhood());
            address.setStreet(addressDTO.getStreet());

            addressRepository.save(address);
            return addressDTO;
        } else {
            return null;
        }
    }

    private AddressDTO convertEntityToDto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(address.getCity());
        addressDTO.setDistrict(address.getDistrict());
        addressDTO.setNeighborhood(address.getNeighborhood());
        addressDTO.setStreet(address.getStreet());

        return addressDTO;
    }

    private Address convertDtoToEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setDistrict(addressDTO.getDistrict());
        address.setNeighborhood(addressDTO.getNeighborhood());
        address.setStreet(addressDTO.getStreet());

        return address;
    }

}