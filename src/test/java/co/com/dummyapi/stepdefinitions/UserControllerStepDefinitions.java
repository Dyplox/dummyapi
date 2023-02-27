package co.com.dummyapi.stepdefinitions;

import co.com.dummyapi.models.User;
import co.com.dummyapi.models.builder.UserBuilder;
import co.com.dummyapi.questions.CodigoRespuestaHttp;
import co.com.dummyapi.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerStepDefinitions {

    public User user = UserBuilder.byDefault();
    public static ResponseOptions<Response> response;
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;

    @Before
    public void configurarElEscenario() {
        setTheStage(new OnlineCast());
        theActorCalled("Robot the supervisor");
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://dummyapi.io/data/v1/");
    }

    @Dado("que Abel quiere acceder al servicio")
    public void queAbelQuiereAccederAlServicio() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Test
    @Cuando("realiza la penticion get para la lista de usuarios")
    public void realizaLaPenticionGetParaLaListaDeUsuarios() {
        theActorInTheSpotlight().attemptsTo(ObtenerLista.usuarios());
    }

    @Test
    @Cuando("realiza la peticion Post para crear el usuario")
    public void realizaLaPeticionPostParaCrearElUsuario() {
        theActorInTheSpotlight().attemptsTo(Crear.usuario(user));
    }

    @Test
    @Cuando("realiza la peticion get el usuario")
    public void realizaLaPeticionGetElUsuario() {
        theActorInTheSpotlight().attemptsTo(Obtener.usuarioPorId(user));
    }

    @Test
    @Cuando("realiza la peticion Put para actualizar el usuario")
    public void realizaLaPeticionPutParaActualizarElUsuario() {
        theActorInTheSpotlight().attemptsTo(Actualizar.usuario(user));
    }

    @Test
    @Cuando("realiza la peticion Delete para eliminar el usuario")
    public void realizaLaPeticionDeleteParaEliminarElUsuario() {
        theActorInTheSpotlight().attemptsTo(Eliminar.usuario(user));
    }

    @Test
    @Entonces("verifica que el codigo HTTP sea {int}")
    public void verificaQueElCodigoHTTPSea(Integer codigo) {
        theActorInTheSpotlight().should(
                seeThat("el codigo de respuesta", CodigoRespuestaHttp.fue(), equalTo(codigo))
                        .orComplainWith(SerenityRest.lastResponse().getBody().jsonPath().get("error"))
        );
    }

    @Test
    @Entonces("el esquema de respuesta para el metodo POST")
    public void elEsquemaDeRespuestaParaElMetodoPost() {
        //String responseBody = response.getBody().asString();
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        assertThat(responseBody, matchesJsonSchemaInClasspath("postUser.json"));
    }
}