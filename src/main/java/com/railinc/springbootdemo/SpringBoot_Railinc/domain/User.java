package com.railinc.springbootdemo.SpringBoot_Railinc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address", nullable = false)
    @JsonManagedReference
    private Address address;

//    @Transient
//    private Integer addressId;

    public User() {

    }

    public User(String firstName, String lastName, Integer idAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(idAddress,"", "","");
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Address getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "User{" +
                ", firstName ='" + firstName + '\'' +
                ", lastName ='" + lastName + '\'' +
                ", Street =" + address.getStreet() + '\'' +
                ", City =" + address.getCity() + '\'' +
                ", State =" + address.getState() +
                '}';
    }
}
