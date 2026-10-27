package com.voting.system.ward;

import  org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.voting.system.ward.dto.CreateWardRequest;
import com.voting.system.ward.dto.WardResponse;

@Mapper(componentModel = "spring")
public interface WardMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target="registeredVoters",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target = "country",ignore = true)
    @Mapping(target = "county",ignore = true)
    @Mapping(target = "constituency",ignore = true)
    Ward toEntity(CreateWardRequest request);

    @Mapping(target ="countryName",source= "country.name")
    @Mapping(target ="countyName",source="county.name")
    @Mapping(target="constituencyName",source= "constituency.name")
    @Mapping(target = "countryId",source = "country.id")
    @Mapping(target = "countyId",source = "county.id")
    @Mapping(target ="constituencyId",source = "constituency.id")
    WardResponse toResponse(Ward ward);
    
}
