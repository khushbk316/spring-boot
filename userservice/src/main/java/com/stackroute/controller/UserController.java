package com.stackroute.controller;


import com.stackroute.domain.User;
import com.stackroute.userservice.UserService;
import exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* @RestController = @Controller + @ResponseBody */



@RestController

@RequestMapping (value = "api/v1")
public class UserController {
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }



    @PostMapping ("user")
    public ResponseEntity<?> saveUser (@RequestBody User user) {

        ResponseEntity responseEntity;

        try {
            userService.saveUser(user);
            responseEntity = new ResponseEntity<String> ("Successfully Completed !!!", HttpStatus.CREATED);
        }
        catch (UserAlreadyExistException e) {
            responseEntity = new ResponseEntity<String> (e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @GetMapping ("user")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

}

