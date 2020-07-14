package com.hotel.management;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hotel.management.endpoint.request.CreateUserRequest;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CustomerControllerTest extends AbstractTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void createAndGetUserTest() throws Exception {
		String uri = "http://localhost:8080/hotelmanagement/user/create";
		String get_uri = "http://localhost:8080/hotelmanagement/user/get/1";
		CreateUserRequest user = getCreateUserRequest();
		String inputJson = mapToJson(user);
		// test for create user
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);

		// create for get user
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(get_uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	public CreateUserRequest getCreateUserRequest() {
		CreateUserRequest user = new CreateUserRequest();
		user.setDob(LocalDate.now());
		user.setEmail("abc@gmail.com");
		user.setFirstName("guru");
		user.setLastName("prasad");
		user.setPassword("xyz@1234");
		return user;
	}

}
