package co.com.dummyapi.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.dummyapi.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Crear implements Task {

    private String firstName;
    private String lastName;
    private String email;

    public Crear(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = "{\n" +
                "    \"firstName\": \"'Abel'\",\n" +
                "    \"lastName\": \"Gutierrez\",\n" +
                "    \"email\": \"test@outlook.com\"\n" +
                "}";

        actor.attemptsTo(
                Post.to(URL_BASE + URI_USER + CREATE_USER)
                        .with(requestSpecification -> requestSpecification
                                .header("app-id", "63f791c396469f998f3335e2")
                                .body(body)
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().statusCode();
        SerenityRest.lastResponse().getBody().prettyPrint();
    }

    public static Crear usuario() {
        return instrumented(Crear.class);
    }
}