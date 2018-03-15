package com.railinc.springbootdemo.SpringBoot_Railinc.controller;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.AddressService;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.UserService;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.iAddService;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.iUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

//    @Autowired
//    private UserService userService;
    @Autowired
    private iUsService userService;
//    @Autowired
//    private iAddService addressService;
//    @Autowired
//    private AddressService addressService;

    @RequestMapping(value = "/demo/user", method = RequestMethod.GET)
    public List<Object> getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/demo/user/{idUser}", method = RequestMethod.GET)
    public List<Object> getAUser(@PathVariable Integer idUser) {
        return userService.getAUser(idUser);
    }


    @RequestMapping(value = "/demo/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = {"/demo/user/firstName/{firstNameUser}", "/demo/user/lastName/{lastNameUser}",
            "/demo/user/street/{streetAddress}"}, method = RequestMethod.PUT)
    public void updateUser(@PathVariable Optional<String> firstNameUser, @PathVariable Optional<String> lastNameUser,
                           @PathVariable Optional<String> streetAddress, @RequestBody User user) {
        userService.updateUser(firstNameUser, lastNameUser, streetAddress, user);
    }

    @RequestMapping(value = "/demo/user/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer idUser) {
        userService.deleteUser(idUser);
    }

}
