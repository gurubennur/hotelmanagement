package com.hotel.management.service;

import java.util.Optional;

import com.hotel.management.model.User;

public interface UserService {

	public User createUser(User user);

	public User getUserById(Long id);

	public Optional<User> findByFirstnameAndLastname(String firstname, String lastname);

}
