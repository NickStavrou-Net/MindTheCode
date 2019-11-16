package com.example.demo.responses;

import java.util.List;

public class GetAllTourPackagesResponse {

    List<TourPackageResponse> tourPackages;

    public GetAllTourPackagesResponse(List<TourPackageResponse> tourPackages) {
        this.tourPackages = tourPackages;
    }

    public List<TourPackageResponse> getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(List<TourPackageResponse> tourPackages) {
        this.tourPackages = tourPackages;
    }
}
