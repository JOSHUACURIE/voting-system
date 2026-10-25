package com.voting.system.country;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voting.system.country.dto.CountryResponse;
import com.voting.system.country.CountryMapper;
import com.voting.system.common.exception.ResourceNotFoundException;
import com.voting.system.country.dto.CreateCountryRequest;
import  java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import com.voting.system.country.CountryRepository;



@Service 
@Transactional 
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    //constructor injection
    public  CountryService(CountryRepository countryRepository,CountryMapper countryMapper){
        this.countryRepository=countryRepository;
        this.countryMapper=countryMapper;
    }

    public CountryResponse createCountry(CreateCountryRequest request){
if(countryRepository.existsByName(request.name())){
    throw new RuntimeException("Country already registered");
}
Country country=countryMapper.toEntity(request);

Country saved=countryRepository.saveAndFlush(country);


return countryMapper.toResponse(saved);
    }

@Transactional (readOnly=true)
public  List<CountryResponse> findAllCountries(){
return  countryRepository.findAll()
.stream()
.map(countryMapper::toResponse)
.toList();
}

public  CountryResponse findCountryById(UUID id){
    Country country=countryRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Country not found: " + id));
      return  countryMapper.toResponse(country);
}
    
}
