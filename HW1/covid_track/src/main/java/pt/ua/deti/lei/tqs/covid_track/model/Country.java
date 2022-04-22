package pt.ua.deti.lei.tqs.covid_track.model;

import java.util.Objects;

import static java.lang.String.format;

public class Country {

    private String officialName;
    private String commonName;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;

    public Country() {}

    public Country(String officialName, String commonName, String cca2, String ccn3, String cca3, String cioc) {
        this.setOfficialName(officialName);
        this.setCommonName(commonName);
        this.setCca2(cca2);
        this.setCcn3(ccn3);
        this.setCca3(cca3);
        this.setCioc(cioc);
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getCca2() {
        return cca2;
    }

    public void setCca2(String cca2) {
        this.cca2 = cca2;
    }

    public String getCcn3() {
        return ccn3;
    }

    public void setCcn3(String ccn3) {
        this.ccn3 = ccn3;
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Country other = (Country) obj;
        if(!this.getCca2().equals(other.getCca2())) {
            return false;
        }
        if(!this.getCca3().equals(other.getCca3())) {
            return false;
        }
        if(!this.getCcn3().equals(other.getCcn3())) {
            return false;
        }
        if(!this.getCioc().equals(other.getCioc())) {
            return false;
        }
        if(!this.getCommonName().equalsIgnoreCase(other.getCommonName())) {
            return false;
        }
        // I prefer to ignore official name, because it can be really ambiguous
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cca2,cca3,ccn3,cioc,commonName);
    }

    @Override
    public String toString() {
        return format("Country: {official name: %s, common name: %s, codes: {cca2: %s, cca3: %s, ccn3: %s, cioc: %s}}",
                getOfficialName(), getCommonName(), getCca2(), getCca3(), getCcn3(), getCioc());
    }
}
