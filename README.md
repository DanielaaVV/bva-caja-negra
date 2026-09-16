# Ejemplo: Caja Negra — Análisis de Valores Límite (BVA)

Proyecto de ejemplo para la exposición de Calidad de Software.
Caso de estudio: validar que la edad de un usuario esté en el rango
permitido **[18, 65]** (ambos inclusive).

## Requisitos

- Java 21 (JDK)
- Maven (o usar el Maven que trae integrado la extensión de Java de VS Code)
- Extensión **Extension Pack for Java** en VS Code (se sugiere sola al abrir la carpeta)

## Cómo abrir

1. Abre esta carpeta completa (`bva-caja-negra`) en VS Code: `File > Open Folder...`
2. Espera a que VS Code indexe el proyecto (ícono de Java en la barra inferior).
3. Ve al ícono de **matraz/Erlenmeyer (Testing)** en la barra lateral para correr los tests
   desde la interfaz, o usa la terminal integrada.

## Estructura del proyecto

```
src/main/java/com/udea/calidad/
├── ValidadorEdad.java          → Lógica de validación CORRECTA
├── ValidadorEdadConBug.java    → Misma lógica, con 1 bug intencional (solo para demo)
├── RegistroUsuario.java        → Caso de uso real que usa el validador
└── EdadInvalidaException.java  → Excepción de negocio

src/test/java/com/udea/calidad/
├── ValidadorEdadTest.java           → 6 casos de BVA (parametrizados) + 1 de robustez
├── RegistroUsuarioTest.java         → Pruebas del caso de uso completo
└── ValidadorEdadConBugDemoTest.java → DEMO: expone el bug en vivo
```

## Cómo correr los tests (terminal)

```bash
# Todos los tests del proyecto
mvn test

# Solo los tests "buenos" (deben pasar todos en verde)
mvn test -Dtest=ValidadorEdadTest,RegistroUsuarioTest

# Solo la demo del bug (uno de los dos tests debe FALLAR en rojo)
mvn test -Dtest=ValidadorEdadConBugDemoTest
```

## Guion sugerido para la demo en vivo

1. Correr `ValidadorEdadTest` primero → todo en verde. Explicar que estos son
   los 6 casos de BVA: antes del mínimo, en el mínimo, después del mínimo,
   y lo mismo en el máximo.
2. Abrir `ValidadorEdadConBug.java` y mostrar el cambio de `>` a `>=`
   en el límite superior — un error de una sola línea, muy fácil de cometer.
3. Correr `ValidadorEdadConBugDemoTest` → el caso con edad "normal" (30) pasa,
   pero el caso límite (65) **falla**. Ese es el punto central de la exposición:
   BVA encuentra errores que una prueba con valores típicos nunca detectaría.
