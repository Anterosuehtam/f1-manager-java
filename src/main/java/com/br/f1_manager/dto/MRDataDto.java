package com.br.f1_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MRDataDto(@JsonProperty("DriverTable") DriverTableDto driverTable,
                        @JsonProperty("ConstructorTable") ConstructorTableDto constructorTable) {
}
