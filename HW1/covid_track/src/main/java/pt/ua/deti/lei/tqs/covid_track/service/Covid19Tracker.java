package pt.ua.deti.lei.tqs.covid_track.service;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pt.ua.deti.lei.tqs.covid_track.connection.ApiHttpClient;
import pt.ua.deti.lei.tqs.covid_track.model.Country;
import pt.ua.deti.lei.tqs.covid_track.model.Report;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;
import static pt.ua.deti.lei.tqs.covid_track.util.Utils.isFuture;
import static pt.ua.deti.lei.tqs.covid_track.util.Utils.loadRegions;

@Service
public class Covid19Tracker {

    private static final String DOMAIN = "https://api.covid19api.com";
    private static final Logger logger = Logger.getLogger(Covid19Tracker.class.getName());

    private List<Country> regions;

    @Autowired
    private ApiHttpClient connection;

    public Covid19Tracker() {
        setRegions(loadRegions());
    }

    public ApiHttpClient getConnection() {
        return connection;
    }

    public void setConnection(ApiHttpClient connection) {
        this.connection = connection;
    }

    public Optional<Report> getReport(Country region, LocalDate date) {
        logger.log(Level.INFO, format("GET Report from Region %s in %s", region.toString(), date.toString()));

        if(!regions.contains(region)) {
            throw new IllegalArgumentException("Given region does not exist!");
        }
        if(isFuture(date)) {
            throw new IllegalArgumentException("Given date is in the future!");
        }







        return Optional.empty();
    }

    public List<Country> getRegions() throws IOException, ParseException {
        logger.log(Level.INFO, format("GET regions: %s", regions.toString()));
        return regions;
    }

    public void setRegions(List<Country> regions) {
        this.regions = regions;
    }


}
