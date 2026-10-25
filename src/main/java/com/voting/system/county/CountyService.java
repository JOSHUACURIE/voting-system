package com.voting.system.county;

import com.voting.system.county.dto.CountyResponse;
import com.voting.system.county.dto.CreateCountyRequest;

import jakarta.transaction.Transactional;

import com.voting.system.country.Country;
import com.voting.system.country.CountryRepository;
import org.springframework.stereotype.Service;

import com.voting.system.county.County;
import com.voting.system.county.CountyRepistory;
import com.voting.system.county.CountyMapper;

@Service 
@Transactional 
public class CountyService {

private final CountyRepistory countyRepistory;
private final CountyMapper countyMapper;
private final CountryRepository countryRepository;

public CountyService(CountyRepistory countyRepistory,CountyMapper countyMapper,CountryRepository countryRepository){
    this.countyRepistory=countyRepistory;
    this.countyMapper=countyMapper;
    this.countryRepository=countryRepository;
}
    

public CountyResponse createCounty(CreateCountyRequest request){
    if(countyRepistory.existsByName(request.name())){
        throw new RuntimeException("County already exists");
    }
   Country country=countryRepository.findById(request.countryId())
   .orElseThrow(() -> new RuntimeException("Country does not exist"));


    County county=countyMapper.toEntity(request);
    county.setCountry(country);
    County saved=countyRepistory.saveAndFlush(county);
    

    return  countyMapper.toResponse(saved);
}
}
