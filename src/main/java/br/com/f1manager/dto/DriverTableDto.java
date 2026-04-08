package br.com.f1manager.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public record DriverTableDto(@SerializedName("Drivers") List<PilotoDto> pilotos) {
}
