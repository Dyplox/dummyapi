package co.com.dummyapi.models.builder;

import co.com.dummyapi.models.Location;
import javafx.util.Builder;

public class LocationBuilder implements Builder<Location> {
    private String street;
    private String city;
    private String state;
    private String country;
    private String timezone;

    public LocationBuilder byDefault() {
        this.street = "47A";
        this.city = "Manizales";
        this.state = "Caldas";
        this.country = "Colombia";
        this.timezone = "UTC-5";

        return new LocationBuilder();
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public Location build() {
        return new Location(this);
    }
}