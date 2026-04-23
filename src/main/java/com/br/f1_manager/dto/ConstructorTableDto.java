package com.br.f1_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ConstructorTableDto(@JsonProperty("Constructors")List<EquipeDto> equipes) {
}
