package co.com.dummyapi.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class UserControllerStepDefinitions {

    @Before
    public void configurarElEscenario() {
        setTheStage(new OnlineCast());
        theActorCalled("ROBOT");
    }

    @Dado("que Abel quiere acceder al servicio")
    public void queAbelQuiereAccederAlServicio() {
        throw new cucumber.api.PendingException();
    }

    @Cuando("realiza la penticion get para la lista de usuarios")
    public void realizaLaPenticionGetParaLaListaDeUsuarios() {
        throw new cucumber.api.PendingException();
    }

    @Entonces("verifica que el codigo HTTP sea {int}")
    public void verificaQueElCodigoHTTPSea(Integer int1) {
        throw new cucumber.api.PendingException();
    }

    @Entonces("el esquema de respuesta")
    public void elEsquemaDeRespuesta() {
        throw new cucumber.api.PendingException();
    }
}