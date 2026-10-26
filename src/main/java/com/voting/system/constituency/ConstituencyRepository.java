package com.voting.system.constituency;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository 
public interface ConstituencyRepository extends  JpaRepository<Constituency,UUID>{

List<Constituency>findByCountryId(UUID id);
List<Constituency>findByCountyId(UUID id);
List<Constituency>findAll();
boolean existsByName(String name);
boolean existsById(UUID id);
Optional<Constituency>findById(UUID id);
void deleteById(UUID id);





}