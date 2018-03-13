package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.dao.UserRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private List<User> users;

    @Autowired
    private UserRepository userRepository;

    /**
     * Get all users data
     * @return
     */
    public List<User> getAllUser() {
       users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    /**
     * Get a specific user base on its Id.
     * @param idUser
     * @return
     */
    public User getAUser(Integer idUser) {
        return userRepository.findOne(idUser);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer idUser, User user) {
        User u = getAUser(idUser);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        userRepository.save(u);
    }

    public void deleteUser(Integer idUser) {
        userRepository.delete(idUser);
    }

    //    /**
//     * Get a User or list of users with the same firstName and/or lastName
//     * @param firstName
//     * @param lastName
//     * @return
//     */
//    public List<User> getUserByName(Optional<String> firstName, Optional<String> lastName) {
//        users = new ArrayList<>();
//        if(firstName.isPresent()) {
//            if(lastName.isPresent()) {
//                userRepository.findByUserFirstNameORLastName(firstName,lastName).ifPresent(users::addAll);
//            }
//            userRepository.findByUserFirstNameORLastName(firstName, null).ifPresent(users::addAll);
//        }else if(lastName.isPresent()) {
//            userRepository.findByUserFirstNameORLastName(null,lastName).ifPresent(users::addAll);
//        }
//        return users;
//    }

}
