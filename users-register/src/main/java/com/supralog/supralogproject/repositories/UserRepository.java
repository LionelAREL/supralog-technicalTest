package com.supralog.supralogproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.supralog.supralogproject.entities.User;

public interface UserRepository extends CrudRepository<User, String> {
}