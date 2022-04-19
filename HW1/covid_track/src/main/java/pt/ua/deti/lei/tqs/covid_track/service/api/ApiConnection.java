package pt.ua.deti.lei.tqs.covid_track.service.api;


import pt.ua.deti.lei.tqs.covid_track.model.Region;
import pt.ua.deti.lei.tqs.covid_track.model.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ApiConnection {

    List<Region> getRegions() throws IOException;
    Optional<Report> getReport(Region region, Date date);
    String getURL();

}
