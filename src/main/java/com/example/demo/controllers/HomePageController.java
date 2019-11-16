package com.example.demo.controllers;

import com.example.demo.services.HomeInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tour-office")
public class HomePageController
{
    @Autowired
    HomeInteractor interactor;

    @GetMapping("/home")
    public ResponseEntity homePage()
    {
        ResponseEntity responseEntity = new ResponseEntity(
                interactor.getHomePage(),
                null,
                HttpStatus.OK
        );
        return responseEntity ;
    }
}
