package com.railinc.springbootdemo.SpringBoot_Railinc.controller;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="demo/user", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping(value="demo/user/{idUser}", method = RequestMethod.GET)
    public Optional<User> getAUser(@PathVariable Integer idUser) {
        return userService.getAUser(idUser);
    }

    @RequestMapping(value="demo/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value="demo/user/{idUser}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Integer idUser, @RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value="demo/user/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer idUser) {
        userService.deleteUser(idUser);
    }

}
