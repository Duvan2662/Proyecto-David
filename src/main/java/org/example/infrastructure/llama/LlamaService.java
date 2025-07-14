package org.example.infrastructure.llama;

import de.kherud.llama.*;
import de.kherud.llama.args.MiroStat;

public class LlamaService {

    private final LlamaModel model;

    public LlamaService(String rutaModelo) {
        ModelParameters params = new ModelParameters().setModel(rutaModelo);
        this.model = new LlamaModel(params);
    }

    public String consultar(String entrada) {
        String prompt = "\nUser: " + entrada + "\nAssistant: ";
        InferenceParameters inferParams = new InferenceParameters(prompt)
                .setTemperature(0.3f)
                .setPenalizeNl(true)
                .setMiroStat(MiroStat.V2)
                .setStopStrings();

        StringBuilder respuesta = new StringBuilder();
        for (LlamaOutput output : model.generate(inferParams)) {
            respuesta.append(output);
        }
        return respuesta.toString().trim();
    }

    public void cerrar() {
        model.close();
    }
}
