package com.example.demo.services;

import com.example.demo.helpers.ApiErrorMessage;
import com.example.demo.mappers.TourMapper;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {

    @Autowired
    private TourMapper mapper;

    @Autowired
    private TourRepository repository;

    @Autowired
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
        for (Tour tour : retrievedTours) {
            if (tour.getTourPackage().getId() == tourPackageId) {
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

/*    public List<TourResponse> getToursBySearch(String search, int id)
    {
        Iterable<Tour> tours = repository.findAll();
        List<TourResponse> tourToReturn = new ArrayList<>();
        if(search.equals("tourPackage"))
        {
            for (Tour tour : tours)
            {
                if(tour.getTourPackage().getId() == id)
                {
                   tourToReturn.add(mapper.mapTourResponseFromTour(tour));
                }
            }
        }
        return  tourToReturn;
    }*/

    public GenericResponse<List<TourResponse>> getToursBySearch(String search, long id)
    {
        Iterable<Tour> tours = repository.findAll();
        List<TourResponse> tourToReturn = new ArrayList<>();

        if(search.equals("tourPackage"))
        {
            if(!tourPackageRepository.findById(id).isPresent())
                return new GenericResponse<>(new ApiErrorMessage(0, "Wrong Input", "TourPackage with id: "+ id + " not found"));

            for (Tour tour : tours)
            {
                if(tour.getTourPackage().getId() == id)
                {
                    tourToReturn.add(mapper.mapTourResponseFromTour(tour));
                }
            }
        }
        return  new GenericResponse<>(tourToReturn);
    }
}
