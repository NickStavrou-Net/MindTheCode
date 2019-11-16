package com.example.demo.responses;

import java.util.List;

public class HomePageResponse
{
    private String title;
    private int numberOfTourPackages;
    private int numberOfUsers;
    private List<TourPackageResponse> tourPackageResponses;
    private List<UserResponse> userResponses;

    public HomePageResponse(String title, int numberOfTourPackages, int numberOfUsers, List<TourPackageResponse> tourPackageResponses, List<UserResponse> userResponses) {
        this.title = title;
        this.numberOfTourPackages = numberOfTourPackages;
        this.numberOfUsers = numberOfUsers;
        this.tourPackageResponses = tourPackageResponses;
        this.userResponses = userResponses;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfTourPackages() {
        return numberOfTourPackages;
    }

    public void setNumberOfTourPackages(int numberOfTourPackages) {
        this.numberOfTourPackages = numberOfTourPackages;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public List<TourPackageResponse> getTourPackageResponses() {
        return tourPackageResponses;
    }

    public void setTourPackageResponses(List<TourPackageResponse> tourPackageResponses) {
        this.tourPackageResponses = tourPackageResponses;
    }

    public List<UserResponse> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }
}
