package co.com.dummyapi.models.builder;

import co.com.dummyapi.models.Location;
import co.com.dummyapi.models.User;
import co.com.dummyapi.utils.Builder;

public class UserBuilder implements Builder<User> {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Location location;

    public UserBuilder() {
        this.id = "";
        this.firstName = "Abel Fernando";
        this.lastName = "Gutierrez Arias";
        this.email = "abel.102@outlook.com";
        this.location = LocationBuilder.byDefault();
    }

    public static User byDefault() {
        return new UserBuilder().build();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public User build() {
        return new User(this);
    }
}