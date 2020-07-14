package com.hotel.management.endpoint.request.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hotel.management.endpoint.request.CreateUserRequest;
import com.hotel.management.model.User;

@Component
public class CreateUserRequestToUser implements Converter<CreateUserRequest, User> {

	@Override
	public User convert(CreateUserRequest source) {
		User user = new User();
		user.setFirstname(source.getFirstName());
		user.setLastname(source.getLastName());
		user.setDob(source.getDob());
		user.setEmail(source.getEmail());
		user.setPassword(source.getPassword());
		return user;
	}

}
