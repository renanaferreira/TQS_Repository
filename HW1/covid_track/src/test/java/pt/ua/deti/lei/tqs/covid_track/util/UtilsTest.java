package pt.ua.deti.lei.tqs.covid_track.util;


import org.junit.jupiter.api.Test;

import pt.ua.deti.lei.tqs.covid_track.model.Country;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static pt.ua.deti.lei.tqs.covid_track.util.Utils.isFuture;
import static pt.ua.deti.lei.tqs.covid_track.util.Utils.loadRegions;

public class UtilsTest {

    @Test
    public void loadRegions_returnListNotEmpty() {
        List<Country> regions = loadRegions();
        assertThat(regions.isEmpty(), is(false));
    }

    @Test
    public void loadRegions_atLeastPTisThere() {
        List<Country> regions = loadRegions();
        Country portugal = new Country();
        portugal.setName("Portugal");
        portugal.setSlug("portugal");
        portugal.setIso("PT");
        assertThat(regions.contains(portugal), is(true));
    }

    @Test
    public void todayIsNotFutureTest() {
        LocalDate today = LocalDate.now();
        boolean res = isFuture(today);

        assertThat(today.isEqual(LocalDate.now()), is(true));
        assertThat(res, is(false));
    }
    @Test
    public void DayIsFutureTest() {
        LocalDate today = LocalDate.now();
        boolean res = isFuture(today.plusDays(10));

        assertThat(res, is(true));
    }

    @Test
    public void DayIsPastTest() {
        LocalDate today = LocalDate.now();
        boolean res = isFuture(today.minusDays(10));

        assertThat(res, is(false));
    }


}
