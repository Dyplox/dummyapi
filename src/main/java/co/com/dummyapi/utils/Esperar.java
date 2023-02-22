package co.com.dummyapi.utils;

import co.com.dummyapi.exception.ThreadStoppedException;

import static co.com.dummyapi.utils.Constantes.THREAD_STOPPED_EXCEPTION_MESSAGE;

public class Esperar {
    private Esperar() {
    }

    public static void stopExecution(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ThreadStoppedException(THREAD_STOPPED_EXCEPTION_MESSAGE, e);
        }
    }
}

