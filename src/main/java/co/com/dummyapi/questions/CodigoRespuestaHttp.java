package co.com.dummyapi.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuestaHttp implements Question {
    public static Question<Integer> fue() {
        return new CodigoRespuestaHttp();
    }

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
