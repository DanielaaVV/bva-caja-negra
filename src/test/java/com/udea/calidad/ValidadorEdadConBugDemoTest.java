package com.udea.calidad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ValidadorEdadConBugDemoTest {

    private final ValidadorEdadConBug validadorConBug = new ValidadorEdadConBug();

    @Test
    @DisplayName("Con una edad 'normal' (30) el bug pasa desapercibido")
    void edadNormal_elBugNoSeNota() {
        assertTrue(validadorConBug.esEdadValida(30));
    }

    @Test
    @DisplayName("DEMO: en el limite superior (65) el bug SI se manifiesta -> FALLA")
    void edadEnElLimiteSuperior_elBugSeManifiesta() {
        assertTrue(validadorConBug.esEdadValida(65),
                "BUG DETECTADO: la edad 65 deberia ser valida, pero el codigo la rechaza.");
    }
}
