package com.udea.calidad;

/**
 * registrar un usuario, aplicando la regla de negocio de edad
 * minima/maxima mediante ValidadorEdad.
 */
public class RegistroUsuario {

    private final ValidadorEdad validadorEdad;

    public RegistroUsuario(ValidadorEdad validadorEdad) {
        this.validadorEdad = validadorEdad;
    }

    /**
     * Registra un usuario si su edad esta dentro del rango permitido.
     *
     * @param nombre nombre del usuario
     * @param edad   edad declarada por el usuario
     * @return un mensaje de confirmacion del registro
     * @throws EdadInvalidaException si la edad esta fuera de [18, 65]
     * @throws IllegalArgumentException si el nombre es nulo o vacio
     */
    public String registrar(String nombre, int edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }

        if (!validadorEdad.esEdadValida(edad)) {
            throw new EdadInvalidaException(
                    edad, ValidadorEdad.EDAD_MINIMA, ValidadorEdad.EDAD_MAXIMA);
        }

        return "Usuario '" + nombre + "' registrado correctamente con " + edad + " anios.";
    }
}
