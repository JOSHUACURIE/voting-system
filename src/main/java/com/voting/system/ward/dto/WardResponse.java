package com.voting.system.ward.dto;
import  java.time.Instant;
import java.util.UUID;

public  record WardResponse(
    UUID id,
    String name,
    String countryName,
    String countyName,
    String constituencyName,
    UUID countryId,
    UUID countyId,
    UUID constituencyId,
    Instant createdAt,
    Instant updatedAt

) {
}
