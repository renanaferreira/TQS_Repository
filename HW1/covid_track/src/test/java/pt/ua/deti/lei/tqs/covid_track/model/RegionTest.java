package pt.ua.deti.lei.tqs.covid_track.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegionTest {


    @Test
    public void regionEqualsOther() {
        String name = "Portugal";
        String cca2 = "PT";
        String cca3 = "PRT";
        String ccn3 = "620";
        String cioc = "POR";

        Country portugal = new Country("Republic of Portugal", name, cca2, ccn3, cca3, cioc);
        Country portugal02 = new Country("PORTugal", "porTUGal", cca2, ccn3, cca3, cioc);

        assertThat(portugal.equals(portugal02), is(true));

    }

    @Test
    public void regionNotEqualsNotIgnoreCase() {
        String ofName = "Republic of Portugal";
        String name = "Portugal";
        String cca2 = "PT";
        String cca3 = "PRT";
        String ccn3 = "620";
        String cioc = "POR";

        Country portugal = new Country(ofName, name, cca2, ccn3, cca3, cioc);
        Country portugal02 = new Country(ofName, "porTUGal", "pt", ccn3, cca3, cioc);

        assertThat(portugal.equals(portugal02), is(false));

    }
}
