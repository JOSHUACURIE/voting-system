package com.voting.system.county;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.voting.system.county.dto.CountyResponse;
import com.voting.system.county.dto.CreateCountyRequest;

@Mapper(componentModel = "spring")
public  interface CountyMapper {
@Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "registeredVoters", ignore = true)   
    @Mapping(target = "country", ignore = true)            

    County toEntity(CreateCountyRequest request);

    
    @Mapping(target = "countryId",   source = "country.id")
    @Mapping(target = "countryName",source = "country.name")
    CountyResponse toResponse(County county);


    
}