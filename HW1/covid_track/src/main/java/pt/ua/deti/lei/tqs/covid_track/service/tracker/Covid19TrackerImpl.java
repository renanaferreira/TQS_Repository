package pt.ua.deti.lei.tqs.covid_track.service.tracker;

import pt.ua.deti.lei.tqs.covid_track.model.Region;
import pt.ua.deti.lei.tqs.covid_track.model.Report;
import pt.ua.deti.lei.tqs.covid_track.model.ReportRange;
import pt.ua.deti.lei.tqs.covid_track.service.tracker.Covid19Tracker;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Covid19TrackerImpl implements Covid19Tracker {

    @Override
    public Optional<Report> getReport(Region region, Date date) {
        return Optional.empty();
    }

    @Override
    public Optional<ReportRange> getReportRange(Region region, Date date) {
        return Optional.empty();
    }

    @Override
    public List<Region> getRegions() {
        return null;
    }
}
