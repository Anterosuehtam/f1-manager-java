package com.br.f1_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PilotoDto(@JsonProperty("driverId") String id,
                        @JsonProperty("givenName") String nome,
                        @JsonProperty("familyName")String sobrenome,
                        @JsonProperty("permanentNumber") String numero,
                        @JsonProperty("code") String sigla,
                        @JsonProperty("nationality") String nacionalidade,
                        @JsonProperty("dateOfBirth") String dataNascimento) {
}
