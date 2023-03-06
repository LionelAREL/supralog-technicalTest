package com.supralog.supralogproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supralog.supralogproject.dto.UserRequest;
import com.supralog.supralogproject.entities.User;
import com.supralog.supralogproject.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
    /** 
     * @param userRequest
     * @return User create with userRequest
     */
    public User saveUser(UserRequest userRequest){
        User user = new User(userRequest.getFirstName(),userRequest.getLastName(),userRequest.getBirthDate(),userRequest.getGender(),userRequest.getMail(),userRequest.getPassword(),userRequest.getRole(),userRequest.getNationality());
        if(userRequest.getPhoneNumber() != null){
            user.setPhoneNumber(user.getPhoneNumber());
        }
        if(userRequest.getZipCode() != null){
            user.setZipCode(userRequest.getZipCode());
        }
        return userRepository.save(user); 
    }

    
}
