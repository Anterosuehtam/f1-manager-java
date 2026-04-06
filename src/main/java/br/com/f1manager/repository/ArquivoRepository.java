package br.com.f1manager.repository;

import br.com.f1manager.model.Piloto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class ArquivoRepository {
    private final Gson gson;

    public ArquivoRepository() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
                        new JsonPrimitive(src.toString()))
                .create();
    }

    public void salvarPilotos(List<Piloto> pilotos, String nomeArquivo) {
        String jsonParaSalvar = gson.toJson(pilotos);

        try {
            Path caminhoDoArquivo = Path.of(nomeArquivo);
            Files.writeString(caminhoDoArquivo, jsonParaSalvar);
            System.out.println("Sucesso! Arquivo salvo em: " + caminhoDoArquivo.toAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException("Falha ao tentar salvar o arquivo no disco: " + e.getMessage());
        }
    }
}
