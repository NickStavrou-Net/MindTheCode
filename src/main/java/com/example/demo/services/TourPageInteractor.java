package com.example.demo.services;

import com.example.demo.responses.TourPageResponse;
import com.example.demo.responses.TourResponse;
import com.example.demo.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPageInteractor
{
    @Autowired
    TourService tourService;
    @Autowired
    UserService userService;

    public TourPageResponse getTourPage()
    {
        List<TourResponse> tourResponses = tourService.getAllTours();
        List<UserResponse> userResponses = userService.getAllUsers();
        int numberOfTours = tourResponses.size();
        int numberOfUsers = userResponses.size();

        TourPageResponse response = new TourPageResponse(numberOfTours, numberOfUsers, tourResponses, userResponses);
        return response;
    }

    ///
 /*   public TourPageResponse getTourByUserStatus(String search)
    {
        List<TourResponse> tourResponses = tourService.getAllTours();
        List<UserResponse> userResponses = (List<UserResponse>) userService.getTourByUserStatus(search);
        int numberOfTours = tourResponses.size();
        int numberOfUsers = userResponses.size();

        TourPageResponse response = new TourPageResponse(numberOfTours,numberOfUsers,tourResponses, userResponses);
        return response;
    }*/
}
