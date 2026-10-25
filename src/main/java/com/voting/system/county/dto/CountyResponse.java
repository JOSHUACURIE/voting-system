package com.voting.system.county.dto;
import java.time.Instant;
import  java.util.UUID;
public  record CountyResponse(
    UUID id,
    String name,
    UUID countryId,
    Instant createdAt,
    Long registeredVoters,
    Instant updatedAt
) {
}