package com.example.demo.pojos;

import java.util.List;

public class TourPageResponse
{
    private int numberOfTours;
    private int numberOfUsers;
    private List<TourResponse> tourResponseList;
    private List<UserResponse> userResponseList;

    public TourPageResponse(int numberOfTours, int numberOfUsers, List<TourResponse> responseList, List<UserResponse> userResponseList) {
        this.numberOfTours = numberOfTours;
        this.numberOfUsers = numberOfUsers;
        this.tourResponseList = responseList;
        this.userResponseList = userResponseList;
    }

    public int getNumberOfTours() {
        return numberOfTours;
    }

    public void setNumberOfTours(int numberOfTours) {
        this.numberOfTours = numberOfTours;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public List<TourResponse> getTourResponseList() {
        return tourResponseList;
    }

    public void setTourResponseList(List<TourResponse> tourResponseList) {
        this.tourResponseList = tourResponseList;
    }

    public List<UserResponse> getUserResponseList() {
        return userResponseList;
    }

    public void setUserResponseList(List<UserResponse> userResponseList) {
        this.userResponseList = userResponseList;
    }
}
