package com.railinc.springbootdemo.SpringBoot_Railinc.controller;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/demo/user", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/demo/user/{idUser}", method = RequestMethod.GET)
    public User getAUser(@PathVariable Integer idUser) {
        return userService.getAUser(idUser);
    }

//    @RequestMapping(value = "/demo/user/{idUser}", method = RequestMethod.GET)
//    public Map<Address, User> getAUser(@PathVariable Integer idUser) {
//        return userService.getAUser(idUser);
//    }

    @RequestMapping(value = "/demo/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

//    @RequestMapping(value = "/demo/user", method = RequestMethod.POST)
//    public void addUser(@RequestBody User user, @RequestBody Address address) {
//        userService.addUser(user, address);
//    }

    @RequestMapping(value = "/demo/user/{idUser}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Integer idUser, @RequestBody User user) {
        userService.updateUser(idUser, user);
    }

    @RequestMapping(value = "/demo/user/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer idUser) {
        userService.deleteUser(idUser);
    }

    //    @RequestMapping(value = {"/demo/user/{firstNameUser}", "/demo/user/{lastNameUser}", "/demo/user/{firstNameUser && lastNameUser}"}, method = RequestMethod.GET)
//    public Optional<List<User>> getUserByName(@PathVariable  Optional<String> firstNameUser, @PathVariable Optional<String> lastNameUser) {
//
//        if(firstNameUser.isPresent()) {
//            if(lastNameUser.isPresent()) {
//                return Optional.ofNullable(userService.getUserByName(firstNameUser, lastNameUser));
//            }
//            return Optional.ofNullable(userService.getUserByName(firstNameUser, null));
//        }else if(lastNameUser.isPresent()) {
//            return Optional.ofNullable(userService.getUserByName(lastNameUser, null));
//        }else {
//            return Optional.ofNullable(getAllUser());
//        }
//
//    }

}
