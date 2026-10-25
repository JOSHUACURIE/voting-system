package com.voting.system.constituency.dto;
import  java.util.UUID;
import  java.time.Instant;
public record ConstituencyResponse(
    UUID id,
    UUID countryId,//
    UUID countyId,//
    String name,//
    String countryName,//
    String countyName,//
    Instant registeredVoters,
    Instant createdAt,
    Instant updatedAt
) {
}