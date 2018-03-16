package com.railinc.springbootdemo.SpringBoot_Railinc.dao;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UARepositoryTest {

    private  User user;
    private Address address;

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        //Address object
        address = new Address();
        address.setStreet("Dorner");
        address.setCity("Raleigh");
        address.setState("NC");

        entityManager.persist(address);
        entityManager.flush();

        //User Object
        user = new User("John", "Doe", address.getId());
        entityManager.persist(user);
        entityManager.flush();
    }

    @Test
    public void findUserAndAddressByUserFirstNameTes() {
        List<Object> expectedObj = userRepository.getAUserByFirstName(java.util.Optional.ofNullable(user.getFirstName()));

        assertThat(expectedObj.isEmpty()).isFalse();
    }

    @Test
    public void findUserAndAddressByUserLastNameTes() {
        List<Object> expectedObj = userRepository.getAUserByLastName(java.util.Optional.ofNullable(user.getLastName()));
        assertThat(expectedObj.isEmpty()).isFalse();
    }
}
