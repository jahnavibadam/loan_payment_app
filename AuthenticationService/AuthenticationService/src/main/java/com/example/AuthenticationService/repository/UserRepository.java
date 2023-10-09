package com.example.AuthenticationService.repository;

import com.example.AuthenticationService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // Find a user by their email
    User findByEmail(String email);

    // Find users by their first name
    List<User> findByFirstName(String firstName);

    // Find users by their last name
    List<User> findByLastName(String lastName);

    // Find users by their first name and last name
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    // Find a user by their Aadhar number
    User findByAadharNumber(String aadharNumber);
}
