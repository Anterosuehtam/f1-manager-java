package com.br.f1_manager.service;

import com.br.f1_manager.dto.ApiResponseDto;
import com.br.f1_manager.dto.PilotoDto;
import com.br.f1_manager.model.Piloto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PilotoService {
    private final Gson gson;

    public PilotoService() {
        this.gson = new GsonBuilder()
                .create();
    }

    public List<Piloto> processarPilotosDaApi(String jsonBody) {

        ApiResponseDto apiResponse = gson.fromJson(jsonBody, ApiResponseDto.class);
        List<PilotoDto> listaDePilotosDto = apiResponse.mrData().driverTable().pilotos();

        List<Piloto> grid = new ArrayList<>();

        for (PilotoDto dto : listaDePilotosDto) {
            // Proteção para caso a data de nascimento for nula
            LocalDate dataNascimentoConvertida = null;
            if (dto.dataNascimento() != null) {
                dataNascimentoConvertida = LocalDate.parse(dto.dataNascimento());
            }

            // Proteção do Número (Se for null, recebe o valor padrão 0)
            int numeroConvertido = 0;
            if (dto.numero() != null) {
                numeroConvertido = Integer.parseInt(dto.numero());
            }

            // Instanciando o objeto da classe Piloto
            Piloto piloto = new Piloto(
                    dto.id(),
                    dto.nome(),
                    dto.sobrenome(),
                    numeroConvertido,
                    dto.sigla(),
                    dto.nacionalidade(),
                    dataNascimentoConvertida,
                    "Desconhecida"
            );
            grid.add(piloto);
        }

        // Aplicando um filtro: O piloto DEVE ter número diferente de 0 E sigla diferente de nulo
        return grid.stream()
                .filter(piloto -> piloto.getNumero() != 0 && piloto.getSigla() != null)
                .collect(Collectors.toList());
    }
}
