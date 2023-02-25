package co.com.dummyapi.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.dummyapi.utils.Constantes.URI_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerLista implements Task {

    public ObtenerLista() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URI_USER)
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .header("app-id", "63f791c396469f998f3335e2")
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().statusCode();
        SerenityRest.lastResponse().getBody().prettyPrint();
    }

    public static ObtenerLista usuarios() {
        return instrumented(ObtenerLista.class);
    }
}