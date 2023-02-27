package co.com.dummyapi.tasks;

import co.com.dummyapi.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GuardarId implements Task {

    private User user;

    public GuardarId(User user) {
        this.user = user;
    }

    @Override
    @Step("{0} save id of user")
    public <T extends Actor> void performAs(T actor) {
        user.setId(SerenityRest.lastResponse().getBody().jsonPath().get("id"));
    }

    public static GuardarId usuario(User user) {
        return instrumented(GuardarId.class, user);
    }
}