package com.voting.system.ward.dto;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public  record CreateWardRequest(
@NotBlank(message = "name is required")
@Size(max = 100)
String name,
@NotNull 
UUID countryId,
@NotNull 
UUID countyId,
@NotNull
UUID constituencyId

) {
}