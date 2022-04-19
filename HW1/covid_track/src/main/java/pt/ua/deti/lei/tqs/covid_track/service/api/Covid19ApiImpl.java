package pt.ua.deti.lei.tqs.covid_track.service.api;

import com.google.gson.Gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import netscape.javascript.JSObject;
import org.springframework.stereotype.Component;

import pt.ua.deti.lei.tqs.covid_track.model.Region;
import pt.ua.deti.lei.tqs.covid_track.model.Report;

import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class Covid19ApiImpl implements ApiConnection {

    private static final String DOMAIN = "https://api.covid19api.com";
    private Gson gson;

    public Covid19ApiImpl() {
        gson = new Gson();
    }

    @Override
    public List<Region> getRegions() throws IOException {

        String resource_addr = DOMAIN + "/countries";
        String json_name = "Country";
        String json_iso = "ISO2";

        List<Region> regions = new ArrayList<>();
        try {
            URLConnection request = (new URL(resource_addr)).openConnection();
            request.connect();
            String content = gson.toJson(request.getContent());

            for (JsonElement elem: gson.fromJson(content, JsonArray.class)) {
                JsonObject region = elem.getAsJsonObject();
                String name = region.get(json_name).toString();
                String iso = region.get(json_iso).toString();

                regions.add(new Region(name, iso));
            }
        } catch (Exception e) {
            throw e;
        }
        return regions;
    }

    @Override
    public Optional<Report> getReport(Region region, Date date) {
        return Optional.empty();
    }

    @Override
    public String getURL() {
        return null;
    }
}
