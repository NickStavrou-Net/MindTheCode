package com.example.demo.services;

import com.example.demo.UsersMapper;
import com.example.demo.pojos.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UsersMapper mapper;

    public List<UserResponse> getAllUsers()
    {
        return mapper.mapUsers(repository.findAll());
    }

    public List<UserResponse> getUserStatus(String userStatus)
    {
        Iterable<UserResponse> mappedUsers = getAllUsers();
        List<UserResponse> users = new ArrayList<>();
        for(UserResponse user : mappedUsers){
            if(user.getStatus().equalsIgnoreCase(userStatus))
                users.add(user);
        }
        return users;
    }
}
