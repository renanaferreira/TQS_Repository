package pt.ua.deti.lei.tqs.covid_track.model;

import java.util.Date;

public class Report {

    private int newCases;
    private int totalCases;

    private int newDeaths;
    private int totalDeaths;

    private int newRecovered;
    private int totalRecovered;

    private int activeCases;

    private Date date;
    private Region Region;

    public Report(int newCases) {
        this.newCases = newCases;
    }





}
