package com.voting.system.country.dto;
import java.time.Instant;
import java.util.UUID;

public  record CountryResponse(
    UUID id,
    String name,
    Instant createdAt,
    Instant updatedAt
) {
}