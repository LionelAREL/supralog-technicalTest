package com.supralog.supralogproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supralog.supralogproject.entities.User;
import com.supralog.supralogproject.exceptions.UserNotFoundException;
import com.supralog.supralogproject.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(String id) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("User with id : " + id +" is not found");
    }

    public User getUserByMail(String mail) throws UserNotFoundException{
        try{
            return this.getAllUsers().stream().filter(usr -> usr.getMail().toLowerCase().equals(mail.toLowerCase())).collect(Collectors.toList()).get(0);
        }
        catch (Exception e){
            throw new UserNotFoundException("User with mail : " + mail +" is not found");
        }
    }
    
}
