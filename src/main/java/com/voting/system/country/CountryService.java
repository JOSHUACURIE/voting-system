package com.voting.system.country;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.voting.system.country.Country;
import com.voting.system.country.dto.CountryResponse;
import com.voting.system.country.CountryMapper;
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


public  List<CountryResponse> findAllCountries(){
return  countryRepository.findAll()
.stream()
.map(countryMapper::toResponse)
.toList();
}

// public CountryResponse getCountryById(UUID id){
//     Country country=countryRepository.findById(id)
//     .orElseThrow(()->ResourceNotFoundException("Country not found "+id))
// }

    
}
