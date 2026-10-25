package com.voting.system.constituency;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.voting.system.constituency.dto.ConstituencyResponse;
import com.voting.system.constituency.dto.CreateConstituencyRequest;

@Mapper(componentModel = "spring")
public interface ConstituencyMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "registeredVoters",ignore = true)
    @Mapping(target = "country",ignore = true)
    @Mapping(target = "county",ignore = true)
    @Mapping(target="createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    Constituency toEntity(CreateConstituencyRequest request);


    @Mapping(target = "countryId",source = "country.id")
    @Mapping(target = "countyId",source = "county.id")
    @Mapping(target = "countryName",source = "country.name")
    @Mapping(target = "countyName",source = "county.name")
    ConstituencyResponse toResponse(Constituency constituency);


    
}
