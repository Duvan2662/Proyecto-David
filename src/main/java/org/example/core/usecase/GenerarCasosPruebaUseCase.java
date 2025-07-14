package org.example.core.usecase;

import org.example.infrastructure.llama.LlamaService;

public class GenerarCasosPruebaUseCase {
    private final LlamaService modelo;

    public GenerarCasosPruebaUseCase(LlamaService modelo) {
        this.modelo = modelo;
    }

    public String generarDesdeHistoria(String historiaUsuario) {
        String prompt = "Basado en la siguiente Historia de Usuario, genera todos los casos de prueba posibles en el siguiente formato:\n" +
                "Cada sección representa un escenario, y dentro de cada sección incluye los casos de prueba considerando las posibles combinaciones de condiciones, entradas y validaciones relevantes.\n" +
                "Usa el prefijo CPXXXXM_YY_SYS_ donde:\n" +
                " - XXXX: número del escenario (ej. 0010, 0020)\n" +
                " - YY: número incremental del caso dentro del escenario\n" +
                " - SYS: indica que son pruebas del sistema\n\n" +
                "Ejemplo:\n" +
                "Sección 1: Validación de documento obligatorio\n" +
                "    Casos de prueba:\n" +
                "    CP0010M_01_SYS_Validar ingreso con documento válido.\n" +
                "    CP0010M_02_SYS_Validar error al dejar el campo documento vacío.\n\n" +
                "A partir de aquí, usa el mismo formato:\n\n" +
                historiaUsuario;
        System.out.println("Longitud del prompt: " + prompt.length());

        return modelo.consultar(prompt);
    }
}
