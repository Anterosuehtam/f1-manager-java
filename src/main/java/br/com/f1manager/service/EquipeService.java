package br.com.f1manager.service;

import br.com.f1manager.dto.ApiResponseDto;
import br.com.f1manager.model.Equipe;
import br.com.f1manager.dto.EquipeDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class EquipeService {
    private final Gson gson;

    public EquipeService() {
        this.gson = new GsonBuilder()
                .create();
    }

    public List<Equipe> processarEquipesDaApi(String jsonBody) {

        ApiResponseDto apiResponse = gson.fromJson(jsonBody, ApiResponseDto.class);
        List<EquipeDto> listaDeEquipesDto = apiResponse.mrData().constructorTable().equipes();

        List<Equipe> equipes = new ArrayList<>();

        for (EquipeDto equipeDto : listaDeEquipesDto) {
            // Instanciando o objeto da classe Equipe
            Equipe equipe = new Equipe(
                    equipeDto.id(),
                    equipeDto.nome(),
                    equipeDto.nacionalidade()
            );
            equipes.add(equipe);
        }
        return equipes;
    }
}
