package com.estebanbula.msusers.service.impl;

import com.estebanbula.msusers.models.entity.User;
import com.estebanbula.msusers.repository.UserRepository;
import com.estebanbula.msusers.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(String id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(String id, User user) {
        return userRepository.findById(id)
                .map(usr -> {
                    usr.setId(id);
                    usr.setName(user.getName());
                    usr.setSurname(user.getSurname());
                    usr.setEmail(user.getEmail());
                    usr.setPassword(user.getPassword());
                    return userRepository.save(usr);
                }).orElseThrow();
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        if (userRepository.findById(id).isPresent()) userRepository.deleteById(id);
    }
}
