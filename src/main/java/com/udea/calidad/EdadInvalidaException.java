package com.udea.calidad;

public class EdadInvalidaException extends RuntimeException {

    public EdadInvalidaException(int edadRecibida, int minimo, int maximo) {
        super(String.format(
                "Edad invalida: %d. Debe estar entre %d y %d anios (ambos inclusive).",
                edadRecibida, minimo, maximo));
    }
}
