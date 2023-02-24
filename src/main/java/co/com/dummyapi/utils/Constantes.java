package co.com.dummyapi.utils;

public class Constantes {

    public static final String URL_BASE = "https://dummyapi.io/data/v1/";
    public static final String URI_USER = "user";
    public static final String CREATE_USER = "create";

    public static final String ID_USER = "TOKEN_VACIO";

    public static final String THREAD_STOPPED_EXCEPTION_MESSAGE = "Esta tarea se detuvo inesperadamente: ";

    private Constantes() {
        throw new IllegalStateException("No se debe instanciar la clase");
    }
}
