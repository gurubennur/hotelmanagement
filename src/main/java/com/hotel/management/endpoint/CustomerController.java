package com.hotel.management.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.endpoint.request.CreateUserRequest;
import com.hotel.management.endpoint.request.converter.CreateUserRequestToUser;
import com.hotel.management.endpoint.response.CreateUserResponse;
import com.hotel.management.endpoint.response.GetUserResponse;
import com.hotel.management.endpoint.response.converter.UserToCreateUserResponse;
import com.hotel.management.endpoint.response.converter.UserToGetUserResponse;
import com.hotel.management.model.User;
import com.hotel.management.service.UserService;

@RestController
@RequestMapping(path = "hotelmanagement/user")
public class CustomerController {
	@Autowired
	private UserToCreateUserResponse userToCreateUserResponseConverter;

	@Autowired
	private CreateUserRequestToUser createUserRequestToUserConverter;

	@Autowired
	private UserToGetUserResponse userToGetUserResponse;

	@Autowired
	private UserService userService;

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {

		User user = createUserRequestToUserConverter.convert(createUserRequest);
		user = userService.createUser(user);
		return userToCreateUserResponseConverter.convert(user);

	}

	@GetMapping(path = "/get/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public GetUserResponse getUser(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		return userToGetUserResponse.convert(user);
	}

}
