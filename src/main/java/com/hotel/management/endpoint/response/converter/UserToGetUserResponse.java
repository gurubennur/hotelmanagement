package com.hotel.management.endpoint.response.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hotel.management.endpoint.response.GetUserResponse;
import com.hotel.management.model.User;

@Component
public class UserToGetUserResponse implements Converter<User, GetUserResponse> {

	@Override
	public GetUserResponse convert(User source) {
		GetUserResponse getUserResponse = new GetUserResponse();
		getUserResponse.setId(source.getId());
		getUserResponse.setEmail(source.getEmail());
		getUserResponse.setDob(source.getDob());
		getUserResponse.setFirstName(source.getFirstname());
		getUserResponse.setLastName(source.getLastname());
		return getUserResponse;
	}

}
