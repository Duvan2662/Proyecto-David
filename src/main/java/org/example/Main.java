package org.example;

import org.example.core.usecase.GenerarCasosPruebaUseCase;
import org.example.infrastructure.llama.LlamaService;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // Inicializar modelo principal
        LlamaService llamaService = new LlamaService("modelos/mistral-7b-instruct-v0.3-q4_k_m.gguf");
        GenerarCasosPruebaUseCase generador = new GenerarCasosPruebaUseCase(llamaService);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce una historia de usuario:");
        String historia = reader.readLine();
        System.out.println("Prompt que se enviará al modelo:");
        System.out.println(generador.generarDesdeHistoria(historia));


        // Generar casos de prueba con el modelo principal
        String resultado = generador.generarDesdeHistoria(historia);

        System.out.println("\n📋 Casos de prueba generados:\n");
        System.out.println(resultado);

        llamaService.cerrar();
    }
}

