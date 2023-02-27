package co.com.dummyapi.tasks;

import co.com.dummyapi.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static co.com.dummyapi.utils.Constantes.URI_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Eliminar implements Task {

    private User user;

    public Eliminar(User user) {
        this.user = user;
    }

    @Override
    @Step("delete user with id {0}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(URI_USER + user.getId())
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .header("app-id", "63f791c396469f998f3335e2")
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().statusCode();
        SerenityRest.lastResponse().getBody().prettyPrint();

    }

    public static Eliminar usuario(User user) {
        return instrumented(Eliminar.class, user);
    }
}
