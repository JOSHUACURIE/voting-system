package com.voting.system.ward;

import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository 
public  interface WardRepository extends  JpaRepository<Ward,UUID>{
    List<Ward>findByCountryId(UUID id);
    List<Ward>findByCountyId(UUID id);
    List<Ward>findByConstituencyId(UUID id);
    Optional<Ward>findByName(String name);
    boolean existsByName(String name);
    Optional<Ward>findById(UUID id);
    List<Ward>findAll();
    void deleteById(UUID id);


    
}