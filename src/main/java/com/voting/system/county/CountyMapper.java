package com.voting.system.county;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.voting.system.county.County;
import com.voting.system.county.dto.CountyResponse;
import com.voting.system.county.dto.CreateCountyRequest;

@Mapper(componentModel = "spring")
public  interface CountyMapper {
@Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "registeredVoters", ignore = true)   // set by entity default (0) / voter service
    @Mapping(target = "country", ignore = true)            // resolved in service
    @Mapping(target = "aspirants", ignore = true)
    @Mapping(target = "competitors", ignore = true)
    @Mapping(target = "constituencies", ignore = true)
    @Mapping(target = "wards", ignore = true)
    County toEntity(CreateCountyRequest request);

    // ---- Entity -> Response ----
    @Mapping(target = "countryId",   source = "country.id")
    @Mapping(target = "countryName", source = "country.name")
    County toEntity(CreateCountyRequest request);

    CountyResponse toResponse(County county);


    
}