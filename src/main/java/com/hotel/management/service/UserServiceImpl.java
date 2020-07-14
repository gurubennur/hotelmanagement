package com.hotel.management.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.dao.UserRepository;
import com.hotel.management.exception.BusinessException;
import com.hotel.management.exception.CustomerNotFoundException;
import com.hotel.management.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		Optional<User> userResponse = findByFirstnameAndLastname(user.getFirstname(), user.getLastname());
		if (userResponse.isPresent()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("FirstName", user.getFirstname());
			map.put("LastName", user.getLastname());
			throw new BusinessException("user alredy exists", map);
		}

		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> userResponse = userRepository.findById(id);
		if (userResponse.isPresent()) {
			return userResponse.get();
		} else {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("id", id.toString());
			throw new CustomerNotFoundException("user not found", map);
		}
	}

	@Override
	public Optional<User> findByFirstnameAndLastname(String firstname, String lastname) {
		return userRepository.findByFirstnameAndLastname(firstname, lastname);
	}

}
