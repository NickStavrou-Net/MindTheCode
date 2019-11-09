package com.example.demo.controllers;

import com.example.demo.services.TourPageInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourPageController
{
    @Autowired
    TourPageInteractor interactor;

    @GetMapping("/tourPage")
    public ResponseEntity tourPage()
    {
        ResponseEntity responseEntity = new ResponseEntity(
                interactor.getTourPage(),
                null,
                HttpStatus.OK
        );
        return responseEntity;
    }
}
