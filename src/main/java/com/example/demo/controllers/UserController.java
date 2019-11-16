package com.example.demo.controllers;

import com.example.demo.InvalidUserStatusException;
import com.example.demo.helpers.ApiErrorMessage;
import com.example.demo.responses.AllUsersResponse;
import com.example.demo.responses.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tour-office")
public class UserController
{

    @Autowired
    UserService service;

    @GetMapping("/allUsers")
    public AllUsersResponse getAllUsers()
    {
        List<UserResponse> users = service.getAllUsers();
        AllUsersResponse response = new AllUsersResponse(users);
        return response;
    }

    @GetMapping("/getUserByStatus/{userStatus}")
    public ResponseEntity getUsersByStatus(@PathVariable String userStatus)
    {
        try
        {
            return new ResponseEntity(
                    new AllUsersResponse(service.getUserStatus(userStatus)),
                    null,
                    HttpStatus.OK);

        } catch (InvalidUserStatusException ex)
        {
            return new ResponseEntity(
                    new ApiErrorMessage(
                            400,
                            "Invalid Status",
                            "status must be new, platinum, loyal, gold"),
                    null,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
