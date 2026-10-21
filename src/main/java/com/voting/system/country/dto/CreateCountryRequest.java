package com.voting.system.country.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public  record CreateCountryRequest( 
@NotBlank(message = "name is required")
@Size (max=100)
String name

) {}