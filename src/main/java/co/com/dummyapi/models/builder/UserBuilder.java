package co.com.dummyapi.models.builder;

import co.com.dummyapi.models.User;
import javafx.util.Builder;

public class UserBuilder implements Builder<User> {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public UserBuilder byDefault() {
        this.id = "6969";
        this.firstName = "Abel Fernando";
        this.lastName = "Gutierrez Arias";
        this.email = "abel.gutierrezarias+10@outlook.com";

        return new UserBuilder();
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

    @Override
    public User build(){
        return new User(this);
    }
}