package com.bbshare.back.service;

import com.bbshare.back.model.User;
import com.bbshare.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(List<String> ids) {
        return (List<User>) userRepository.findAllById(ids);
    }

    public List<User> getAllUsers() {return (List<User>) userRepository.findAll();}

    public User addUser(String lastname, String firstname) {
        User user = new User();
        user.setLastname(lastname);
        user.setFirstname(firstname);
        return userRepository.save(user);
    }

}