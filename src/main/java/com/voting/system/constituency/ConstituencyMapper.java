package com.voting.system.constituency;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.voting.system.constituency.dto.ConstituencyResponse;
import com.voting.system.constituency.dto.CreateConstituencyRequest;

@Mapper(componentModel = "spring")
public class ConstituencyMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "registeredVoters",ignore = true)
    @Mapping (target = "county",ignore = true)
    
}
