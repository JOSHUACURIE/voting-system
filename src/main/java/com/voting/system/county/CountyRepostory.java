package com.voting.system.county;



import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository 
public  interface CountyRepostory extends JpaRepository<County,UUID> {
    List<County> findByIdCountryId(UUID id);
     Optional<County> findById(UUID id);
    boolean existsByName(String name);

    
}