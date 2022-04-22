package pt.ua.deti.lei.tqs.covid_track.service;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import pt.ua.deti.lei.tqs.covid_track.connection.ApiHttpClient;

import java.util.logging.Logger;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Covid19TrackerTest {


    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Mock
    private ApiHttpClient conn;

    @InjectMocks
    private Covid19Tracker tracker;

}
