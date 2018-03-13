package com.railinc.springbootdemo.SpringBoot_Railinc.dao;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

    @Query("SELECT ut FROM User ut WHERE ut.firstName =?1 OR ut.lastName =?2")
    Optional<List<User>> findByUserFirstNameORLastName(Optional<String> firstName, Optional<String> lastName);

}
