package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;

import java.util.List;
import java.util.Optional;

public interface IAddService {

    /**
     * Return all address data from Address table
     * Package/End Point/Action:
     *                      com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController
     *                     /demo/user
     *                     GET
     * @return
     */
    List<Address> getAllAddress();

    Address getAAddress(Integer idAddress);

    void addAddress(Address address);

    void  updateAddress(Integer idAddress, Address address);

    void deleteAddress(Integer idAddress);

    void updateAddressStreet(String street, Optional<String> streetAddress, String city, String state);

    List<Address> findByAddressStreet(String street);

    void deleteAllInBatch();

    Integer getAAddressIdByStreetAndCityAndState(Address address);
}
