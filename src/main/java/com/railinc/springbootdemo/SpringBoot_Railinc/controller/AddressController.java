package com.railinc.springbootdemo.SpringBoot_Railinc.controller;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/demo/address", method = RequestMethod.GET)
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @RequestMapping(value = "/demo/address/{idAddress}", method = RequestMethod.GET)
    public Address getAAddress(@PathVariable Integer idAddress) {
        return addressService.getAAddress(idAddress);
    }

    @RequestMapping(value = "/demo/address", method = RequestMethod.POST)
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @RequestMapping(value = "/demo/address/{idAddress}", method = RequestMethod.PUT)
    public void updateAddress(@PathVariable Integer idAddress, @RequestBody Address address) {
        addressService.updateAddress(idAddress, address);
    }

    @RequestMapping(value = "/demo/address/{idAddress}", method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable Integer idAddress) {
        addressService.deleteAddress(idAddress);
    }
}
