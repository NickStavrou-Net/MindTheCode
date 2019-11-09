package com.example.demo.controllers;

import com.example.demo.pojos.HomePageResponse;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourPackageResponse;
import com.example.demo.pojos.UserResponse;
import com.example.demo.services.HomeInteractor;
import com.example.demo.services.TourPackageService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomePageController
{
    @Autowired
    HomeInteractor interactor;

    @GetMapping("/home")
    public HomePageResponse homePage()
    {
        return interactor.getHomePage();
    }
}
