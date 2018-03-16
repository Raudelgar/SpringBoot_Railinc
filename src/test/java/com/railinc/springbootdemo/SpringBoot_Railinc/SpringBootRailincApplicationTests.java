package com.railinc.springbootdemo.SpringBoot_Railinc;

import com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController;
import com.railinc.springbootdemo.SpringBoot_Railinc.dao.AddressRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.dao.UserRepository;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.AddressService;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.IAddService;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.IUsService;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.UserService;
import com.sun.org.apache.bcel.internal.generic.IADD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRailincApplicationTests {

	@Test
	public void contextLoads() {
	}

}
