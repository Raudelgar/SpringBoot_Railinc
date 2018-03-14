package com.railinc.springbootdemo.SpringBoot_Railinc.dao;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("select adt.id from Address adt where adt.street =?1 and adt.city =?2 and adt.state =?3")
    Integer findByAddressStreetAndCityAndState(String street, String city, String state);
}

//@Query("SELECT ut FROM User ut WHERE ut.firstName =?1 OR ut.lastName =?2")
//Optional<List<User>> findByUserFirstNameORLastName(Optional<String> firstName, Optional<String> lastName);