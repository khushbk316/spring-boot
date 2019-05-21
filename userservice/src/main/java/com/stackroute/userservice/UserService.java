package com.stackroute.userservice;

import com.stackroute.domain.User;
import exceptions.UserAlreadyExistException;

import java.util.List;

public interface UserService {

    public User saveUser (User user) throws UserAlreadyExistException;
    public List<User> getAllUsers();

}
