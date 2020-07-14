package com.hotel.management.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByFirstnameAndLastname(String firstname, String lastname);

	Optional<User> findById(Long id);
}
