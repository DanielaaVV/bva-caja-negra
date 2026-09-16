package com.udea.calidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas del caso de uso "registrar usuario", que envuelve la
 * regla de negocio de ValidadorEdad en un escenario mas real.
 */
class RegistroUsuarioTest {

    private RegistroUsuario registro;

    @BeforeEach
    void setUp() {
        registro = new RegistroUsuario(new ValidadorEdad());
    }

    @Test
    @DisplayName("Registra correctamente a un usuario en el limite inferior (18)")
    void registraUsuarioEnLimiteInferior() {
        String resultado = registro.registrar("Daniela", 18);
        assertTrue(resultado.contains("registrado correctamente"));
    }

    @Test
    @DisplayName("Registra correctamente a un usuario en el limite superior (65)")
    void registraUsuarioEnLimiteSuperior() {
        String resultado = registro.registrar("Carlos", 65);
        assertTrue(resultado.contains("registrado correctamente"));
    }

    @Test
    @DisplayName("Rechaza a un usuario justo por debajo del minimo (17)")
    void rechazaUsuarioMenorAlLimite() {
        EdadInvalidaException ex = assertThrows(EdadInvalidaException.class,
                () -> registro.registrar("Juan", 17));
        assertTrue(ex.getMessage().contains("Edad invalida"));
    }

    @Test
    @DisplayName("Rechaza a un usuario justo por encima del maximo (66)")
    void rechazaUsuarioMayorAlLimite() {
        assertThrows(EdadInvalidaException.class,
                () -> registro.registrar("Marta", 66));
    }

    @Test
    @DisplayName("Rechaza el registro si el nombre viene vacio")
    void rechazaNombreVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> registro.registrar("  ", 30));
    }
}
