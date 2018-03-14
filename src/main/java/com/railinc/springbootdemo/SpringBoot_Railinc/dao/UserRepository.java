package com.railinc.springbootdemo.SpringBoot_Railinc.dao;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("select ut.id from User ut where ut.firstName =?1 and ut.lastName =?2 and ut.address =?3")
    Optional<Integer> findByUserIdByFirstNameAndLastNameAndAddressId(String firstName, String lastName, Integer address);

    @Query("select ut.firstName, ut.lastName, adt.street, adt.city, adt.state from User ut, Address adt where ut.address =  adt.id and ut.id =?1")
    List<Object> findByUserId(Integer id);

    @Query("select ut.firstName, ut.lastName, adt.street, adt.city, adt.state from User ut, Address adt where ut.address = adt.id")
    List<Object> findByUser();

}

