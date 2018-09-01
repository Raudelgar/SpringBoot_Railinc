package com.railinc.springbootdemo.SpringBoot_Railinc.service;

import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)

public class ServiceTest {


    @Autowired
    private IUsService usService;




   @Test
    public void whenAddressNulltest() {



   }

}
