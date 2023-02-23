package co.com.dummyapi.models;

import co.com.dummyapi.models.builder.UserBuilder;

public class User {

    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String dateOfBirth;
    private String registerDate;
    private String phone;
    private String picture;
    private Location location;


    public User(UserBuilder builder) {
        this.id = builder.getId();
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.email = builder.getEmail();
        this.location = builder.build().getLocation();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getPicture() {
        return picture;
    }

    public Location getLocation() {
        return location;
    }

}