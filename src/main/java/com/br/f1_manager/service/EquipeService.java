package com.br.f1_manager.service;

import com.br.f1_manager.client.F1ApiClient;
import com.br.f1_manager.dto.ApiResponseDto;
import com.br.f1_manager.dto.EquipeDto;
import com.br.f1_manager.model.Equipe;
import com.br.f1_manager.repository.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipeService {

    private final F1ApiClient apiClient;
    private final EquipeRepository repository;

    public void carregarEquipesDaTemporada(int ano){

        String endpoint = ano + "/constructors.json";
        ApiResponseDto resposta = apiClient.obterDados(endpoint, ApiResponseDto.class);

        List<EquipeDto> equipesDto = resposta.mrData().constructorTable().equipes();

        System.out.println("Encontradas " + equipesDto.size() + " equipes. Salvando no banco...");

        for (EquipeDto dto : equipesDto) {

            Equipe equipeOficial = new Equipe();

            equipeOficial.setId(dto.id());
            equipeOficial.setNome(dto.nome());
            equipeOficial.setNacionalidade(dto.nacionalidade());

            repository.save(equipeOficial);
        }
    }
}
