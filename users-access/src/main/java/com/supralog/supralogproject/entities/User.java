package com.supralog.supralogproject.entities;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.supralog.supralogproject.entities.enums.Gender;
import com.supralog.supralogproject.entities.enums.Nationality;
import com.supralog.supralogproject.entities.enums.Role;
import com.supralog.supralogproject.utils.Calculator;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    @Indexed(unique = true)
    private String mail;
    private String password;
    private Role role;
    private Nationality nationality;
    //optional
    private String phoneNumber; //optional
    private String zipCode;

    // field no on db
    @Transient
    private int age;

    public User(String firstName,String lastName,LocalDate birthDate,Gender gender,String mail,String password, Role role,Nationality nationality){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mail = mail;
        this.password = password;
        this.role = role;
        this.nationality = nationality;
    }

    
    /** 
     * @return int current age
     */
    public int getAge(){
        return Calculator.YearsBetween(this.birthDate, LocalDate.now());
    }
    
}
