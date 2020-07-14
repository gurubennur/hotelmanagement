package com.hotel.management.endpoint.response.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hotel.management.model.User;
import com.hotel.management.endpoint.response.CreateUserResponse;

@Component
public class UserToCreateUserResponse implements Converter<User, CreateUserResponse> {

	@Override
	public CreateUserResponse convert(User source) {

		CreateUserResponse createUserResponse = new CreateUserResponse();
		createUserResponse.setId(source.getId());
		createUserResponse.setEmail(source.getEmail());
		createUserResponse.setDob(source.getDob());
		createUserResponse.setFirstName(source.getFirstname());
		createUserResponse.setLastName(source.getLastname());
		return createUserResponse;
	}

}
