package com.stackroute.userservice;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if(userRepository.existsById(user.getId()))
            throw new UserAlreadyExistException("user already exists...");
        User saveUser= userRepository.save(user);
        if(saveUser==null)
            throw  new UserAlreadyExistException("null user already exists...");
        return saveUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll() ;
    }
}
