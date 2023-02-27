package co.com.dummyapi.tasks;

import co.com.dummyapi.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import net.thucydides.core.annotations.Step;

import static co.com.dummyapi.utils.Constantes.ID_USER;
import static co.com.dummyapi.utils.Constantes.URI_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Actualizar implements Task {

    private User user;
    private String phone;
    private String dateOfBirth;

    public Actualizar(User user) {
        this.user = user;
    }

    @Override
    @Step("{0} update the user with #id ")
    public <T extends Actor> void performAs(T actor) {
        String body = "{\n" +
                "    \"phone\": \"'300 605 5622'\",\n" +
                "    \"dateOfBirth\": \"18-11-1995\",\n" +
                "}";

        actor.attemptsTo(
                Patch.to(URI_USER + ID_USER)
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .header("app-id", "63f791c396469f998f3335e2")
                                .body(body)
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().statusCode();
        SerenityRest.lastResponse().getBody().prettyPrint();
    }

    public static Actualizar usuario(User user) {
        return instrumented(Actualizar.class, user);
    }
}