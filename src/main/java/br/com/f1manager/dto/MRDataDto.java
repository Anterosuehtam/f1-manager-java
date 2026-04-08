package br.com.f1manager.dto;

import com.google.gson.annotations.SerializedName;

public record MRDataDto(@SerializedName("DriverTable") DriverTableDto driverTable,
                        @SerializedName("ConstructorTable") ConstructorTableDto constructorTable) {
}
