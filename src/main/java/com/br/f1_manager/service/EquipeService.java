package com.br.f1_manager.service;
import com.br.f1_manager.dto.ApiResponseDto;
import com.br.f1_manager.dto.EquipeDto;
import com.br.f1_manager.model.Equipe;
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
