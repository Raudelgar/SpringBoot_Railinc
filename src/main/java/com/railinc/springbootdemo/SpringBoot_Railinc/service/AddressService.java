package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.dao.AddressRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private List<Address> addresses;

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddress() {
        addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    public Address getAAddress(Integer idAddress) {
        return addressRepository.findOne(idAddress);
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public void updateAddress(Integer idAddress, Address address) {
        Address a = getAAddress(idAddress);
        a.setStreet(address.getStreet());
        a.setCity(address.getCity());
        a.setState(address.getState());
        addressRepository.save(a);
    }


    public void deleteAddress(Integer idAddress) {
        addressRepository.delete(idAddress);
    }
}
