package pt.ua.deti.lei.tqs.covid_track.service.tracker;

import pt.ua.deti.lei.tqs.covid_track.model.Region;
import pt.ua.deti.lei.tqs.covid_track.model.Report;
import pt.ua.deti.lei.tqs.covid_track.model.ReportRange;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Covid19Tracker {

    Optional<Report> getReport(Region region, Date date);
    Optional<ReportRange> getReportRange(Region region, Date date);
    List<Region> getRegions();

}
