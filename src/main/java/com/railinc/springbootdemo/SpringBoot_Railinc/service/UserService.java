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
    private List<Object> userObj;
    private Map<Address, User> mapUA;
    private User user = null;
    boolean addressExist = false;
    boolean userExist = false;
    private Integer addressId;
    Optional<Integer> userId;

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;

    /**
     * Get all userList data
     * @return
     */
    public List<Object> getAllUser() {
        userObj = new ArrayList<>();
        userRepository.findByUser().forEach(userObj::add);
        return userObj;
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
//    public User getAUser(Integer idUser) {
//        user = userRepository.findOne(idUser);
//        return user;
//    }

    /**
     * Get user data, address related by user id
     * @param idUser
     * @return
     */
    public List<Object> getAUser(Integer idUser) {
        userObj = new ArrayList<>();
        userRepository.findByUserId(idUser).forEach(userObj::add);
        return userObj;
    }

    public Optional<Integer> getUserIdByFirstNameAndLastNameAndAddressId(User user) {
        return userRepository.findByUserIdByFirstNameAndLastNameAndAddressId(user.getFirstName(), user.getLastName(), user.getIdAddress());
    }


//    public Map<Address, User> getAUser(Integer idUser) {
//        user = userRepository.findOne(idUser);
//        mapUA.put(user.getAddress(),user);
//        return mapUA;
//    }

//    public void addUser(User user) {
//        userRepository.save(user);
//    }

    /**
     * Add a new user if doesn't exist in the database
     * check if address exist in address_table, if not save new address
     * @param userIn
     */
    public void addUser(User userIn) {
        //check if address exist to avoid duplicate data, return id
        addressId = checkAddressId(userIn.getAddress());
        //if user exist with same address
        userId = checkUserId(userIn);

        if(userExist) {
            return;
        }else {
            this.user = new User(userIn.getFirstName(), userIn.getLastName(), addressId);
            userRepository.save(this.user);
        }

    }

    private Integer checkAddressId(Address address) {
        Integer id = addressService.getAAddressIdByStreetAndCityAndState(address);
        if(null != id) {
            addressExist = true;
        }else {
            addressService.addAddress(address);
            id = addressService.getAAddressIdByStreetAndCityAndState(address);
        }

        return id;
    }

    private Optional<Integer> checkUserId(User user) {
        Optional<Integer> id = null;
        id = getUserIdByFirstNameAndLastNameAndAddressId(user);
        if(id.isPresent()) {
            userExist = true;
            return id;
        }
        return id;
    }

//    public void updateUser(Integer idUser, User user) {
//        if(null != getAUser(idUser)) {
//            this.user = (User) getAUser(idUser);
//        } else {
//            return;
//        }
//
//        if(null != user.getFirstName() && "".equals(user.getFirstName())) {
//            this.user.setFirstName(user.getFirstName());
//        }
//        if(null != user.getLastName() && "".equals(user.getLastName())) {
//            this.user.setLastName(user.getLastName());
//        }
//
//        userRepository.save(this.user);
//    }

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
