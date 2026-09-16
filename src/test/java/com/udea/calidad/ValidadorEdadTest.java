package com.udea.calidad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Suite de pruebas basada en Analisis de Valores Limite (BVA)
 * para el rango de edad permitido [18, 65].
 *
 * Los 6 casos cubren: antes del minimo, en el minimo, despues del
 * minimo, antes del maximo, en el maximo y despues del maximo.
 */
class ValidadorEdadTest {

    private final ValidadorEdad validador = new ValidadorEdad();

    @DisplayName("BVA: casos limite del rango de edad [18, 65]")
    @ParameterizedTest(name = "edad={0} -> esperado={1} ({2})")
    @CsvSource({
            "17, false, Justo antes del minimo",
            "18, true,  Minimo valido",
            "19, true,  Justo despues del minimo",
            "64, true,  Justo antes del maximo",
            "65, true,  Maximo valido",
            "66, false, Justo despues del maximo"
    })
    void validaLimitesDeEdad(int edad, boolean esperado, String descripcion) {
        assertEquals(esperado, validador.esEdadValida(edad),
                () -> "Fallo en caso: " + descripcion);
    }

    @Test
    @DisplayName("Caso adicional de robustez: edad negativa debe rechazarse")
    void edadNegativa_debeRechazar() {
        assertEquals(false, validador.esEdadValida(-1));
    }
}
