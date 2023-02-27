package co.com.dummyapi.tasks;

import co.com.dummyapi.models.User;
import com.google.gson.Gson;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static co.com.dummyapi.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Crear implements Task {
    private User user;

    public Crear(User user) {
        this.user = user;
    }

    @Override
    @Step("{0} create the user with data by default")
    public <T extends Actor> void performAs(T actor) {
        String json = new Gson().toJson(user);
        actor.attemptsTo(
                Post.to(URI_USER + CREATE_USER)
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .header("app-id", "63f791c396469f998f3335e2")
                                .body(json)
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().getBody().prettyPrint();
        actor.attemptsTo(GuardarId.usuario(user));
        actor.remember(ID_USER, user.getId());
    }

    public static Crear usuario(User user) {
        return instrumented(Crear.class, user);
    }
}