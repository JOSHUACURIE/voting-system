package com.voting.system.repository;

import  com.voting.system.entity.County;

import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository 
public  interface CountyRepostory extends JpaRepository<County,UUID> {
    List<County> findByIdCountyId(UUID id);
    boolean existsByName(String name);

    
}