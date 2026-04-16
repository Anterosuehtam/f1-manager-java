package com.br.f1_manager.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public record DriverTableDto(@SerializedName("Drivers") List<PilotoDto> pilotos) {
}
