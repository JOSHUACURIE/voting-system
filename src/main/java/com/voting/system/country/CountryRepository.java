package com.voting.system.country;


import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository 
 public interface CountryRepository extends JpaRepository<Country,UUID> {
 Optional<Country>findByName(String name);
 boolean existsByName(String name);
 List<Country>findAll();
 Optional<Country>findById(UUID id);
 }