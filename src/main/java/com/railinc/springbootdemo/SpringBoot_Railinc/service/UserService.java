package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.dao.AddressRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.dao.UserRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class UserService {

    private List<User> userList;
    private Map<Address, User> mapUA;
    private User user = null;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    /**
     * Get all userList data
     * @return
     */
    public List<User> getAllUser() {
        userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

//    public Map<Address, User> getAllUser() {
//       userList = new ArrayList<>();
//        userRepository.findAll().forEach(userList::add);
//        mapUA = new HashMap<>();
//        return mapUA;
//    }

    /**
     * Get a specific user base on its Id.
     * @param idUser
     * @return
     */
    public User getAUser(Integer idUser) {
        user = userRepository.findOne(idUser);
        return user;
    }


//    public Map<Address, User> getAUser(Integer idUser) {
//        user = userRepository.findOne(idUser);
//        mapUA.put(user.getAddress(),user);
//        return mapUA;
//    }

    public void addUser(User user) {
        userRepository.save(user);
    }

//    public void addUser(User user, Address address) {
//        //find user and address if they exist
//        //if address exist, skip save address
//        //if user exist, compare addresses
//        //if the addresses are the same skip save user
////        user.setAddress(address);
////        Set<User> usersSet = new HashSet<>();
////        usersSet.add(user);
////        address.setUsers(usersSet);
//        addressRepository.save(address);
//        userRepository.save(user);
//    }

    public void updateUser(Integer idUser, User user) {
        if(null != getAUser(idUser)) {
            this.user = (User) getAUser(idUser);
        } else {
            return;
        }

        if(null != user.getFirstName() && "".equals(user.getFirstName())) {
            this.user.setFirstName(user.getFirstName());
        }
        if(null != user.getLastName() && "".equals(user.getLastName())) {
            this.user.setLastName(user.getLastName());
        }

        userRepository.save(this.user);
    }

    public void deleteUser(Integer idUser) {
        userRepository.delete(idUser);
    }

    //    /**
//     * Get a User or list of userList with the same firstName and/or lastName
//     * @param firstName
//     * @param lastName
//     * @return
//     */
//    public List<User> getUserByName(Optional<String> firstName, Optional<String> lastName) {
//        userList = new ArrayList<>();
//        if(firstName.isPresent()) {
//            if(lastName.isPresent()) {
//                userRepository.findByUserFirstNameORLastName(firstName,lastName).ifPresent(userList::addAll);
//            }
//            userRepository.findByUserFirstNameORLastName(firstName, null).ifPresent(userList::addAll);
//        }else if(lastName.isPresent()) {
//            userRepository.findByUserFirstNameORLastName(null,lastName).ifPresent(userList::addAll);
//        }
//        return userList;
//    }

}
