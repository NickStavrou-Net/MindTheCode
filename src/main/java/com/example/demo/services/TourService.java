package com.example.demo.services;

import com.example.demo.helpers.ApiErrorMessage;
import com.example.demo.mappers.TourMapper;
import com.example.demo.responses.GenericResponse;
import com.example.demo.pojos.Tour;
import com.example.demo.responses.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {

    //Constructor Dependency Injection
    public TourService(TourMapper mapper, TourRepository repository, TourPackageRepository tourPackageRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.tourPackageRepository = tourPackageRepository;
    }

    private TourMapper mapper;
    private TourRepository repository;
    private TourPackageRepository tourPackageRepository;

    public List<TourResponse> getAllTours()
    {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();

        for (Tour tour : retrievedTours) {
            tours.add(mapper.mapTourResponseFromTour(tour));
        }

        return tours;
    }

    public List<TourResponse> getToursByPackageId(Long tourPackageId)
    {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();
        for (Tour tour : retrievedTours)
        {
            if (tour.getTourPackage() !=null && tour.getTourPackage().getId() == tourPackageId) {
                tours.add(mapper.mapTourResponseFromTour(tour));
            }
        }
        return tours;
    }

    public List<TourResponse> getExpensiveTours()
    {
        List<TourResponse> mappedTours = getAllTours();
        List<TourResponse> tours = new ArrayList<>();
        for (TourResponse tour : mappedTours) {
            if (tour.getFinalPrice() > 500)
                tours.add(tour);
        }
        return tours;
    }

    public GenericResponse<List<TourResponse>> getToursBySearch(String search, long id)
    {
        Iterable<Tour> tours = repository.findAll();
        List<TourResponse> tourToReturn = new ArrayList<>();

        if(search.equals("tourPackage"))
        {
            if(!tourPackageRepository.findById(id).isPresent())
                return new GenericResponse<>(new ApiErrorMessage(404, "Wrong Input", "TourPackage with id: "+ id + " not found"));

            for (Tour tour : tours)
            {
                if(tour.getTourPackage().getId() == id)
                {
                    tourToReturn.add(mapper.mapTourResponseFromTour(tour));
                }
            }
        }
        return new GenericResponse<>(tourToReturn);
    }

}
