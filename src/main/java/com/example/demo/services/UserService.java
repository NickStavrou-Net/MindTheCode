package com.example.demo.services;

import com.example.demo.InvalidUserStatusException;
import com.example.demo.mappers.UsersMapper;
import com.example.demo.pojos.User;
import com.example.demo.responses.GenericResponse;
import com.example.demo.responses.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository repository;

    @Autowired
    UsersMapper mapper;

    public List<UserResponse> getAllUsers()
    {
        return mapper.mapUsers(repository.findAll());
    }

    public List<UserResponse> getUserStatus(String userStatus) throws InvalidUserStatusException
    {
        if(!userStatus.equalsIgnoreCase("new") &&
            !userStatus.equalsIgnoreCase("loyal") &&
            !userStatus.equalsIgnoreCase("gold") &&
            !userStatus.equalsIgnoreCase("platinum"))
            throw new InvalidUserStatusException();

        Iterable<User> mappedUsers = repository.findAll();
        List<UserResponse> users = new ArrayList<>();
        for(User user : mappedUsers)
        {
            if(String.valueOf(user.getStatus()).equalsIgnoreCase(userStatus))
            {
                UserResponse userToAdd = mapper.mapUserToUserResponse(user);
                users.add(userToAdd);
            }
        }
        return users;
    }

}
