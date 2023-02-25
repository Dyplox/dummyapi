package co.com.dummyapi.utils.endpoints;

public enum Usuario {

    URL_BASE_("https://dummyapi.io/data/v1/");

    private final String endpoint;

    Usuario(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return "Usuario endpoint='" + endpoint + '}';
    }
}