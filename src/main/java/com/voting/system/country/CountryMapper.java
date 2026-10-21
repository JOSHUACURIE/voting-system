package com.voting.system.country;

import com.voting.system.country.dto.CountryResponse;
import com.voting.system.country.dto.CreateCountryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "registeredVoters",ignore = true)
    Country toEntity(CreateCountryRequest request);

    CountryResponse toResponse(Country country);
}