package com.estebanbula.msusers.service;

import com.estebanbula.msusers.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();
    User findUser(String id);
    User saveUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
}
