package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUsService {

    /**
     * Return all user and address data combined
     * For each firstName and lastName type User
     * retrieved the according street, city and state
     * from Address table
     * Package/End Point/Action:
     *                      com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController
     *                     /demo/user
     *                     GET
     * @return
     */
    List<Object> getAllUser();

    /**
     * For a given id user will retrieved the specified
     * firstName and lastName type User and its corresponding
     * street, city and state from Address table.
     * Package/End Point/Action:
     *                  com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController
     *                  /demo/user/{idUser}
     *                  GET
     * @param idUser
     * @return
     */
    List<Object> getAUser(Integer idUser);

    /**
     * Add a new user if doesn't exist in the database
     * check if address exist in address_table, if not save new address
     * Need implement private methods to check if address data already exist,
     * as well if user data exist, to avoid duplicate rows in User table and Address Table.
     * Package/End Point/Action:
     *                  com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController
     *                  /demo/user
     *                  POST
     * @param userIn
     */
    void addUser(User userIn);

    /**
     * Target optional end points to update firstName and lastName in User table,
     * and street in Address Table.
     * Package/End Point/Action:
     *                  com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController
     *                  {"/demo/user/firstName/{firstNameUser}", "/demo/user/lastName/{lastNameUser}",
     *                  "/demo/user/street/{streetAddress}"}
     *                  PUT
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param user
     */
    void updateUser(Optional<String> firstName, Optional<String> lastName, Optional<String> streetAddress, User user);

    /**
     * Remove a single row in User Table by user id
     * Package/End Point/Action:
     *                  com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController
     *                  /demo/user/{idUser}
     *                  DELETE
     * @param idUser
     */
    void deleteUser(Integer idUser);


    /**
     * Return a user(s) by optional firstName or LastName attribute from User Table.
     * Package/End Point/Action:
     *                  com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController
     *                  {"/demo/user/firstName/{firstNameUser}", "/demo/user/lastName/{lastNameUser}"}
     *                  GET
     *
     * @param firstNameUser
     * @param lastNameUser
     * @return
     */
    List<Object> getAUserByName(Optional<String> firstNameUser, Optional<String> lastNameUser);

}
