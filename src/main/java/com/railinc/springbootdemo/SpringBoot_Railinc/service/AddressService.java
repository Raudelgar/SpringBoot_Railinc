package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.dao.AddressRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    public void  updateAddress(Integer idAddress, Address address) {
        Address a = null;

        if(null != getAAddress(idAddress)) {
            a = getAAddress(idAddress);
        } else {
            return;
        }

        if(null != address.getStreet() && "".equals(address.getStreet())) {
            a.setStreet(address.getStreet());
        }
        if(null != address.getCity() && "".equals(address.getCity())) {
            a.setCity(address.getCity());
        }
        if(null != address.getState() && "".equals(address.getState())) {
            a.setState(address.getState());
        }

        addressRepository.save(a);
    }


    public void deleteAddress(Integer idAddress) {
        addressRepository.delete(idAddress);
    }
}
