package com.railinc.springbootdemo.SpringBoot_Railinc.controller;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.IUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private IUsService userService;


    @RequestMapping(value = "/demo/user", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getAllUser() {
        return new ResponseEntity<List<Object>>(userService.getAllUser(), HttpStatus.OK);
    }


    @RequestMapping(value = "/demo/user/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getAUser(@PathVariable Integer idUser) {
        return new ResponseEntity<List<Object>>(userService.getAUser(idUser), HttpStatus.OK);
    }

    @RequestMapping(value = {"/demo/user/firstName/{firstNameUser}", "/demo/user/lastName/{lastNameUser}"}, method = RequestMethod.GET)
    public List<Object> getAUserByName(@PathVariable Optional<String> firstNameUser, @PathVariable Optional<String> lastNameUser) {
        return userService.getAUserByName(firstNameUser, lastNameUser);
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
