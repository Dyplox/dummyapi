package co.com.dummyapi.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static co.com.dummyapi.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Actualizar implements Task {

    private String id;
    private String phone;
    private String dateOfBirth;

    public Actualizar(String id, String phone, String dateOfBirth) {
        this.id = id;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = "{\n" +
                "    \"phone\": \"'300 605 5622'\",\n" +
                "    \"dateOfBirth\": \"18-11-1995\",\n" +
                "}";

        actor.attemptsTo(
                Patch.to(URL_BASE_TEST + URI_USER + ID_USER)
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

    public static Actualizar usuario(String id) {
        return instrumented(Actualizar.class, id);
    }
}