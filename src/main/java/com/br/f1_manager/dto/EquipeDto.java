package com.br.f1_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EquipeDto(@JsonProperty("constructorId") String id,
                        @JsonProperty ("name") String nome,
                        @JsonProperty ("nationality") String nacionalidade) {
}
