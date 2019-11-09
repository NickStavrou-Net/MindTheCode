package com.example.demo.controllers;

import com.example.demo.helpers.ApiErrorMessage;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.GetAllToursResponse;
import com.example.demo.pojos.TourResponse;
import com.example.demo.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TourController {

    @Autowired
    private TourService service;

    @GetMapping("/allTours")
    public GetAllToursResponse getAllTours()
    {
        return new GetAllToursResponse(service.getAllTours());
    }

    @GetMapping("/getToursByPackageId/{tourPackageId}")
    public GetAllToursResponse getToursByPackageId(@PathVariable Long tourPackageId)
    {
        return new GetAllToursResponse(service.getToursByPackageId(tourPackageId));
    }

    @GetMapping("/expensiveTours")
    public GetAllToursResponse getExpensiveTours()
    {
        return new GetAllToursResponse(service.getExpensiveTours());
    }

    @GetMapping("/getToursBySearch/{search}/{id}")
    public ResponseEntity getToursBySearchCriteria(@PathVariable String search, @PathVariable int id)
    {
        if(!search.equals("tourPackage"))
            return new ResponseEntity(
                    new ApiErrorMessage(400, "Wrong Search", "The input should be tourPackage"),
                    null,
                    HttpStatus.BAD_REQUEST
            );

        GenericResponse<List<TourResponse>> response = service.getToursBySearch(search, id);

        if(response.getErrorMessage() != null)
            return new ResponseEntity(
                    response.getErrorMessage(),
                    null,
                    HttpStatus.BAD_REQUEST

            );
        return new ResponseEntity(
                new GetAllToursResponse(response.getData()),
                        null,
                        HttpStatus.OK
        );
    }

/*    @GetMapping("/getToursBySearch/{search}/{id}")
    public GetAllToursResponse getToursBySearchCriteria(@PathVariable String search, @PathVariable int id)
    {
        return new GetAllToursResponse(service.getToursBySearch(search, id));
    }*/
}
