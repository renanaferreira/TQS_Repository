package pt.ua.deti.lei.tqs.covid_track.util;

import org.apache.commons.logging.Log;
import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ua.deti.lei.tqs.covid_track.connection.ApiHttpClient;
import pt.ua.deti.lei.tqs.covid_track.model.Country;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Utils {

    private static final Logger logger = Logger.getLogger(Utils.class.getName());

    private ApiHttpClient conn;
    private List<Country> countries;

    public ApiHttpClient getConn() {
        return conn;
    }

    @Autowired
    public void setConn(ApiHttpClient conn) {
        this.conn = conn;
    }

    // I was suppose to use a Bean to instantiate the Covidtracker region list
    public List<Country> loadRegions() {
        if(countries == null) {
            List<Country> lst = new ArrayList<>();
            try {

                String domain = "https://restcountries.com/v3.1/all";
                URIBuilder uriBuilder = new URIBuilder(domain);
                String response = conn.doHttpGet(uriBuilder.toString());

                JSONArray arr = (JSONArray) new JSONParser().parse(response);

                for(int i = 0; i < arr.size(); i++) {
                    JSONObject elem = (JSONObject) arr.get(i);
                    JSONObject names = (JSONObject) elem.get("name");

                    Country country = new Country(
                            (String) names.get("official"),
                            (String) names.get("common"),
                            (String) elem.get("cca2"),
                            (String) elem.get("ccn3"),
                            (String) elem.get("cca3"),
                            (String) elem.get("cioc")
                    );
                    lst.add(country);
                }


            } catch(URISyntaxException e) {
                logger.log(Level.SEVERE, "The web address does not exist or it was poorly established");
                throw new RuntimeException(e);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "The web resource is not available");
                throw new RuntimeException(e);
            } catch (ParseException e) {
                logger.log(Level.SEVERE, "It was not possible to parse response to a JSON document");
                throw new RuntimeException(e);
            } finally {
                this.countries = lst;
            }

        }
        return this.countries;
    }

    public static Boolean isFuture(LocalDate date) {
        LocalDate today = LocalDate.now();
        return date.isAfter(today);
    }

}
