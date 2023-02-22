package co.com.dummyapi.utils.endpoints;

public enum Usuario {

    USUARIO("https://dummyapi.io/data/v1/"), USER("user/");

    private final String endpoint;

    Usuario(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return "Usuario{ endpoint='" + endpoint + '}';
    }
}