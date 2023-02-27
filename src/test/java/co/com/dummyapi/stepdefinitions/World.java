package co.com.dummyapi.stepdefinitions;

import co.com.dummyapi.models.User;
import co.com.dummyapi.models.builder.UserBuilder;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class World {
    User user;


    public World(User user) {
        this.user = user;
    }


}