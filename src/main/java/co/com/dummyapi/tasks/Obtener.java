package co.com.dummyapi.tasks;

import co.com.dummyapi.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static co.com.dummyapi.utils.Constantes.URI_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Obtener implements Task {

    private User user;

    public Obtener(User user) {
        this.user = user;
    }

    @Override
    @Step("{0} fetches the user with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URI_USER + user.getId())
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .header("app-id", "63f791c396469f998f3335e2")
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().statusCode();
        SerenityRest.lastResponse().getBody().prettyPrint();
    }

    public static Obtener usuarioPorId(User user) {
        return instrumented(Obtener.class, user);
    }
}