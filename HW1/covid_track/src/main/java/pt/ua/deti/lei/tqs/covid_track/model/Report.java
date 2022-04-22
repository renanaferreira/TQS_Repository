package pt.ua.deti.lei.tqs.covid_track.model;

import java.time.LocalDate;

public class Report {

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    private int newCases;
    private int totalCases;

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    private int newDeaths;

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    private int totalDeaths;

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    private int newRecovered;

    public int getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    private int totalRecovered;

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    private int activeCases;

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    private int avgWeekNewCases;

    public int getAvgWeekNewCases() {
        return avgWeekNewCases;
    }

    public void setAvgWeekNewCases(int avgWeekNewCases) {
        this.avgWeekNewCases = avgWeekNewCases;
    }

    private int avgWeekNewDeaths;

    public int getAvgWeekNewDeaths() {
        return avgWeekNewDeaths;
    }

    public void setAvgWeekNewDeaths(int avgWeekNewDeaths) {
        this.avgWeekNewDeaths = avgWeekNewDeaths;
    }

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private Country Region;

    public Country getRegion() {
        return Region;
    }

    public void setRegion(Country region) {
        Region = region;
    }

    public Report() {}







}
