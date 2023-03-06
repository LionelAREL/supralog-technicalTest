package com.supralog.supralogproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supralog.supralogproject.entities.User;
import com.supralog.supralogproject.exceptions.UserNotFoundException;
import com.supralog.supralogproject.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="")
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String mail) throws UserNotFoundException {
        if(mail != null){
            return ResponseEntity.ok(userService.getUserByMail(mail));
        }
        else{
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
}
