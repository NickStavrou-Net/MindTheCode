package com.example.demo;

import com.example.demo.mappers.TourMapper;
import com.example.demo.pojos.Tour;
import com.example.demo.responses.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import com.example.demo.services.TourService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TourServiceShould
{
    private TourService service;
    @Mock
    private TourMapper mapper;
    @Mock
    private TourRepository tourRepository;
    @Mock
    private TourPackageRepository tourPackageRepository;

    private Iterable<Tour> mockedTours = new ArrayList<Tour>()
    {
        {
            add(new Tour(1000, 100, "katamaran in Mykonos", "Enjoy half day in a Katamaran", "Eat and drink without limit while enjoyinh the local beaches"));
            add(new Tour(600, 60, "Ouzaki tasting", "Drink ouzo", "Enjoy half day drinking the best ouzo in Greece"));
        }

    };

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);//prepei panta na yparxei
        when(tourRepository.findAll()).thenReturn(mockedTours);
        when(mapper.mapTourResponseFromTour(ArgumentMatchers.any())).thenReturn((new TourResponse(1,1000, 400, 600,"title", "short", "long", "packageTitle")));
        service = new TourService(mapper, tourRepository, tourPackageRepository);
    }

    @Test
    public void retrieveToursFromRepository()
    {
        service.getAllTours();//etsi kalo ta tour apo to repository
        Mockito.verify(tourRepository).findAll();
    }

    @Test
    public void usesTourMapper()
    {
        service.getAllTours();
        Mockito.verify(mapper,times(2)).mapTourResponseFromTour(ArgumentMatchers.any());//an theloume na klithei kai den kseroume ta input
                                                                                //gia na erthei sosto dioti to repo epistrefei null
    }

    @Test
    public void returnListOfTourResponse()
    {
        List<TourResponse> output = service.getAllTours();
        Assert.assertEquals(2, output.size());//ta 2 einai avta poy exoume ftiaksei
        //Assert.assertEquals();
    }

}
