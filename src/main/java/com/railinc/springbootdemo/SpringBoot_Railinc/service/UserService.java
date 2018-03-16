package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.SpringBootRailincApplication;
import com.railinc.springbootdemo.SpringBoot_Railinc.dao.UserRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class UserService implements IUsService {

    private static Logger log = LoggerFactory.getLogger(SpringBootRailincApplication.class);

    private List<Object> userObj;
    private User user = null;
    boolean addressExist = false;
    boolean userExist = false;
    private Integer addressId;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService;


    @Override
    public List<Object> getAllUser() {
        userObj = new ArrayList<>();
        userRepository.findByUser().forEach(userObj::add);
        return userObj;
    }


    @Override
    public List<Object> getAUser(Integer idUser) {
        userObj = new ArrayList<>();
        userRepository.findByUserId(idUser).forEach(userObj::add);
        return userObj;
    }

    @Override
    public void addUser(User userIn) {
        //check if address exist to avoid duplicate data, return id
        addressId = checkAddressId(userIn.getAddress());
        //if user exist with same address
        checkUserId(userIn);

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

    private Integer checkUserId(User user) {
        Integer id = null;
        id = getUserIdByFirstNameAndLastNameAndAddressId(user);
        if(null != id) {
            userExist = true;
            return id;
        }
        return id;
    }

    private Integer getUserIdByFirstNameAndLastNameAndAddressId(User user) {
        return userRepository.findByUserIdByFirstNameAndLastNameAndAddressId(user.getFirstName(), user.getLastName(),
                user.getAddress().getStreet(), user.getAddress().getCity(), user.getAddress().getState());
    }

    @Override
    public void updateUser(Optional<String> firstName, Optional<String> lastName, Optional<String> streetAddress, User user) {

        if(firstName.isPresent()) {
            userRepository.updateUserFirstName(user.getFirstName(), firstName, user.getAddress().getStreet(),
                    user.getAddress().getCity(), user.getAddress().getState());
        }

        if(lastName.isPresent()) {
            userRepository.updateUserLastName(user.getLastName(), lastName, user.getAddress().getStreet(),
                    user.getAddress().getCity(), user.getAddress().getState());
        }

        if(streetAddress.isPresent()) {
            addressService.updateAddressStreet(user.getAddress().getStreet(), streetAddress, user.getAddress().getCity(),
                    user.getAddress().getState());
        }

    }

    @Override
    public void deleteUser(Integer idUser) {
        userRepository.delete(idUser);
    }

    @Override
    public List<Object> getAUserByName(Optional<String> firstNameUser, Optional<String> lastNameUser) {
        userObj = new ArrayList<>();

        if (firstNameUser.isPresent()) {
            userRepository.getAUserByFirstName(firstNameUser).forEach(userObj::add);
            return userObj;
        }

        else if(lastNameUser.isPresent()) {
            userRepository.getAUserByLastName(lastNameUser).forEach(userObj::add);
            return userObj;
        }else {
            return null;
        }

    }

}
