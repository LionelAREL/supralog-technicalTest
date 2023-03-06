package com.supralog.supralogproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.supralog.supralogproject.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}