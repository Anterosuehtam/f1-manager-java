package com.br.f1_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record DriverTableDto(@JsonProperty("Drivers") List<PilotoDto> pilotos) {
}
