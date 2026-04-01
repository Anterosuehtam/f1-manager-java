package br.com.f1manager.model;

import com.google.gson.annotations.SerializedName;

public record MRDataDto(@SerializedName("DriverTable") DriverTableDto driverTable) {
}
