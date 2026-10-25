package com.voting.system.county.dto;
import java.time.Instant;
import  java.util.UUID;
public  record CountyResponse(
    UUID id,
    String name,
    UUID countryId,
    Instant createdAt,
    String countryName,
    Long registeredVoters,
    Instant updatedAt
) {
}