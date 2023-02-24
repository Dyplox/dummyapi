package co.com.dummyapi.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Get extends RestInteraction {

    private final String resource;

    public Get(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().get(as(actor).resolve(resource));
    }

    public static net.serenitybdd.screenplay.rest.interactions.Get resource(String resource) {
        return instrumented(net.serenitybdd.screenplay.rest.interactions.Get.class, resource);
    }
}
