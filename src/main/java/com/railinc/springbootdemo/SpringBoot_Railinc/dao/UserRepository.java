package com.railinc.springbootdemo.SpringBoot_Railinc.dao;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("select ut.id from User ut where ut.firstName =?1 and ut.lastName =?2 and ut.address = "+
            "(select adt.id from Address adt where adt.street =?3 and adt.city =?4 and adt.state =?5)")
    Integer findByUserIdByFirstNameAndLastNameAndAddressId(String firstName, String lastName, String street, String city, String state);

    @Query("select ut.firstName, ut.lastName, adt.street, adt.city, adt.state from User ut, Address adt where ut.address ="+
            "  adt.id and ut.id =?1")
    List<Object> findByUserId(Integer id);

    @Query("select ut.firstName, ut.lastName, adt.street, adt.city, adt.state from Address adt inner join adt.users ut where ut.firstName =?1")
    List<Object> getAUserByFirstName(Optional<String> firstName);

    @Query("select ut.firstName, ut.lastName, adt.street, adt.city, adt.state from Address adt inner join adt.users ut where ut.lastName =?1")
    List<Object> getAUserByLastName(Optional<String> lastName);

    @Query("select ut.firstName, ut.lastName, adt.street, adt.city, adt.state from User ut, Address adt where ut.address = adt.id")
    List<Object> findByUser();

    @Modifying
    @Query("update User ut set ut.firstName = ?1 where ut.firstName =?2 and ut.address = (select adt.id from Address adt where " +
            "adt.street =?3 and adt.city =?4 and adt.state =?5)")
    void updateUserFirstName(String firstName, Optional<String> firstNameUser, String street, String city, String state);

    @Modifying
    @Query("update User ut set ut.lastName = ?1 where ut.lastName =?2 and ut.address = (select adt.id from Address adt where " +
            "adt.street =?3 and adt.city =?4 and adt.state =?5)")
    void updateUserLastName(String lastName, Optional<String> lastNameUser, String street, String city, String state);

}

//@Query("select ut.firstName, ut.lastName, adt.street, adt.city, adt.state from User ut inner join ut.address adt on ut.address " +
//            " = adt.id where ut.firstName =?1")