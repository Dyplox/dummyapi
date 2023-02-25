package co.com.dummyapi.tasks;

import co.com.dummyapi.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GuardarId implements Task {

    private User user;

    public GuardarId(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


    }

    public static GuardarId usuario(User user) {
        return instrumented(GuardarId.class, user);
    }
}