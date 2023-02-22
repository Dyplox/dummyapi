package co.com.dummyapi.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class UserControllerStepDefinitions {

    @Before
    public void configurarElEscenario() {
        setTheStage(new OnlineCast());
        theActorCalled("ROBOT");
    }

    @Dado("que Abel quiere acceder al servicio")
    public void queAbelQuiereAccederAlServicio() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Cuando("realiza la penticion get para la lista de usuarios")
    public void realizaLaPenticionGetParaLaListaDeUsuarios() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Entonces("verifica que el codigo HTTP sea {int}")
    public void verificaQueElCodigoHTTPSea(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Entonces("el esquema de respuesta")
    public void elEsquemaDeRespuesta() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}