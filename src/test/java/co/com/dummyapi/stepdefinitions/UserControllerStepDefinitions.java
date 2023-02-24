package co.com.dummyapi.stepdefinitions;

import co.com.dummyapi.questions.CodigoRespuestaHttp;
import co.com.dummyapi.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.dummyapi.utils.Constantes.URL_BASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerStepDefinitions {

    @Before
    public void configurarElEscenario() {
        setTheStage(new OnlineCast());
        theActorCalled("ROBOT");
    }

    @Dado("que Abel quiere acceder al servicio")
    public void queAbelQuiereAccederAlServicio() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(URL_BASE));
    }

    @Cuando("realiza la penticion get para la lista de usuarios")
    public void realizaLaPenticionGetParaLaListaDeUsuarios() {
        theActorInTheSpotlight().attemptsTo(ObtenerLista.usuarios());
    }

    @Cuando("realiza la peticion get el usuario")
    public void realizaLaPeticionGetElUsuario() {
        theActorInTheSpotlight().attemptsTo(Obtener.usuario());
    }

    @Cuando("realiza la peticion Post para crear el usuario")
    public void realizaLaPeticionPostParaCrearElUsuario() {
        theActorInTheSpotlight().attemptsTo(Crear.usuario(nombre, cargo));
    }

    @Cuando("realiza la peticion Put para actualizar el usuario")
    public void realizaLaPeticionPutParaActualizarElUsuario() {
        theActorInTheSpotlight().attemptsTo(Actualizar.usuario(id, nombre, cargo));
    }

    @Cuando("realiza la peticion Delete para eliminar el usuario")
    public void realizaLaPeticionDeleteParaEliminarElUsuario() {
        theActorInTheSpotlight().attemptsTo(Eliminar.usuario(id));
    }

    @Entonces("verifica que el codigo HTTP sea {int}")
    public void verificaQueElCodigoHTTPSea(Integer codigo) {
        theActorInTheSpotlight().should(
                seeThat("el codigo de respuesta", CodigoRespuestaHttp.fue(), equalTo(codigo))
        );
    }

    @Entonces("el esquema de respuesta")
    public void elEsquemaDeRespuesta() {
    }
}