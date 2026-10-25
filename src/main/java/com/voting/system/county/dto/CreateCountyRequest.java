package com.voting.system.county.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import  java.util.UUID;
public  record CreateCountyRequest(
    @NotBlank(message = "name is required")
    @Size(max=100)
    String name,
    UUID countryId

) {
}