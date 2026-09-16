package com.udea.calidad;

/**
 * Valida que una edad se encuentre dentro de un rango permitido.
 *
 * Caso de estudio para Analisis de Valores Limite (BVA):
 * rango valido = [EDAD_MINIMA, EDAD_MAXIMA] = [18, 65], ambos inclusive.
 *
 * Los puntos de mayor riesgo de error NO estan en el centro del rango
 * (ej. edad = 30), sino justo en sus fronteras: 17/18/19 y 64/65/66.
 */
public class ValidadorEdad {

    public static final int EDAD_MINIMA = 18;
    public static final int EDAD_MAXIMA = 65;

    /**
     * Version CORRECTA: usa < y > para excluir, lo que deja
     * el rango [18, 65] cerrado (ambos limites incluidos).
     */
    public boolean esEdadValida(int edad) {
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            return false;
        }
        return true;
    }
}
