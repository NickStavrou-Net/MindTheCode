package com.example.demo.services;

import com.example.demo.responses.HomePageResponse;
import com.example.demo.responses.TourPackageResponse;
import com.example.demo.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeInteractor//otan 2 klaseis den exoun sxesi metaksi toys tote ftiaxnoume ena service san kai avto
{
    @Autowired
    UserService userService;
    @Autowired
    TourPackageService tourPackageService;

    public HomePageResponse getHomePage()
    {
        List<TourPackageResponse> tourPackageResponses = tourPackageService.getAllTourPackages();
        List<UserResponse> userResponses = userService.getAllUsers();
        int numberOfTourPackages = tourPackageResponses.size();
        int numberOfUsers = userResponses.size();
        String title = "Home Page";

        HomePageResponse response = new HomePageResponse(title, numberOfTourPackages, numberOfUsers, tourPackageResponses, userResponses);
        return response;
    }

}
