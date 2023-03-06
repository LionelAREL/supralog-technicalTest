package com.supralog.supralogproject.dto;

import java.time.LocalDate;
import java.time.Period;

import com.mongodb.lang.Nullable;
import com.supralog.supralogproject.entities.enums.Gender;
import com.supralog.supralogproject.entities.enums.Nationality;
import com.supralog.supralogproject.entities.enums.Role;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "firstname shouldn't be blank")
    @NotNull(message = "firstname shouldn't be null")
    private String firstName;
    @NotBlank(message = "lastname shouldn't be blank")
    @NotNull(message = "lastname shouldn't be null")
    private String lastName;
    @NotNull(message = "birth date shouldn't be null")
    private LocalDate birthDate;
    @NotNull(message = "gender shouldn't be null")
    private Gender gender;
    @NotBlank(message = "email shouldn't be blank")
    @NotNull(message = "email shouldn't be null")
    @Email(message = "invalid email address")
    private String mail;
    @NotBlank(message = "password shouldn't be blank")
    @NotNull(message = "password shouldn't be null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",message = "invalid password, should contain minimum eight characters, at least one uppercase letter, one lowercase letter and one number")
    private String password;
    @NotNull(message = "role shouldn't be null")
    private Role role;
    @NotNull(message = "nationality shouldn't be null")
    private Nationality nationality; 

    //optional
    @Nullable
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",message = "invalid mobile number entered ")
    private String phoneNumber;
    @Nullable
    @Pattern(regexp = "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)",message = "invalid zipcode entered ")
    private String zipCode;

    
    /** 
     * @return int current age
     */
    public int getAge(){
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
