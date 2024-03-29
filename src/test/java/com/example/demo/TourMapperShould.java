package com.example.demo;

import com.example.demo.mappers.TourMapper;
import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourPackage;
import com.example.demo.responses.TourResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TourMapperShould
{

    private TourMapper mapper;
    private TourPackage tourPackageInput;
    private Tour tourInput;
    private TourResponse output;

    @Before
    public void setup()
    {
        mapper = new TourMapper();
        tourInput = new Tour(1000, 400, "Da best tour", "shorty", "longy");
        tourInput.setId(100);
        tourPackageInput = new TourPackage("package desc da best", 3000, "Ionio");
        tourPackageInput.setId(200);
        tourInput.setTourPackage(tourPackageInput);
        output = mapper.mapTourResponseFromTour(tourInput);
    }

    @Test
    public void keepSameId()
    {
       Assert.assertEquals(100, output.getId());
    }

    @Test
    public void keepSamePrice()
    {
        Assert.assertEquals(400, output.getDiscount());
    }

    @Test
    public void calculateFinalPriceByPriceDiscount()
    {
        Assert.assertEquals(600, output.getFinalPrice());
    }

    @Test
    public void keepSameTitle()
    {
        Assert.assertEquals(tourInput.getTitle(), output.getTitle());
    }

    @Test
    public void keepShortDescription()
    {
        Assert.assertEquals(tourInput.getShortDescription(), output.getShortDescription());
    }

    @Test
    public void keepLongDescription()
    {
        Assert.assertEquals(tourInput.getLongDescription(), output.getLongDescription());
    }

    @Test
    public void setTitleFromTourPackage()
    {
        Assert.assertEquals(tourInput.getTourPackage().getDesc(), output.getTourPackageTitle());
    }

}
