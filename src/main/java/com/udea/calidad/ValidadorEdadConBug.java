package com.udea.calidad;

/**
 * Version CON BUG de ValidadorEdad, pensada solo para la demo en vivo
 * de la exposicion.
 *
 * El error es minimo y muy realista: se cambio ">" por ">=" en la
 * comparacion del limite superior. El codigo compila sin problema y
 * pasa cualquier prueba con una edad "normal" (ej. 30 anios), pero
 * rechaza incorrectamente a un usuario de exactamente 65 anios, que
 * SI deberia ser aceptado.
 *
 * Este es justamente el tipo de error que BVA esta disenado para
 * detectar: se manifiesta unicamente en el valor limite.
 */
public class ValidadorEdadConBug {

    public static final int EDAD_MINIMA = 18;
    public static final int EDAD_MAXIMA = 65;

    public boolean esEdadValida(int edad) {
        // BUG: deberia ser "edad > EDAD_MAXIMA"
        if (edad < EDAD_MINIMA || edad >= EDAD_MAXIMA) {
            return false;
        }
        return true;
    }
}
