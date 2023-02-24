package co.com.dummyapi.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.dummyapi.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Eliminar implements Task {

    private int id;

    public Eliminar(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(URL_BASE + URI_USER + ID_USER)
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .header("app-id", "63f791c396469f998f3335e2")
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().statusCode();
        SerenityRest.lastResponse().getBody().prettyPrint();

    }

    public static Eliminar usuario(int id) {
        return instrumented(Eliminar.class, id);
    }
}
