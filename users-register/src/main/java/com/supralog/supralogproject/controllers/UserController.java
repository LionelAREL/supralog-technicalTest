package com.supralog.supralogproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supralog.supralogproject.dto.UserRequest;
import com.supralog.supralogproject.entities.User;
import com.supralog.supralogproject.entities.enums.Nationality;
import com.supralog.supralogproject.services.UserService;

import jakarta.validation.Valid;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> postUser(@Valid @RequestBody UserRequest userRequest){
        Map<String, String> errorBody = new LinkedHashMap<String, String>();
        if(!(userRequest.getAge() > 18)){
            errorBody.put("age","you must be >18");
        }
        if(!userRequest.getNationality().equals(Nationality.FRENCH)){
            errorBody.put("nationality","you must be French");
        }
        if(!errorBody.isEmpty()){
            return new ResponseEntity<>(errorBody, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }
    
}
