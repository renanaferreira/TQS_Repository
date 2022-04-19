package pt.ua.deti.lei.tqs.covid_track.model;

import java.util.Objects;

public class Region {

    private String name;
    private String iso;

    public Region() {}

    public Region(String name, String iso) {
        this.name = name;
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Region other = (Region) obj;
        if(this.getName() != other.getName()) {
            return false;
        }
        if(this.getIso() != other.getIso()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, iso);
    }
}
