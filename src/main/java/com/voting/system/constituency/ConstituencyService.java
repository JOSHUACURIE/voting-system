package com.voting.system.constituency;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Service;
import com.voting.system.country.CountryRepository;
import com.voting.system.county.CountyRepistory;
import  com.voting.system.county.County;
import com.voting.system.common.exception.ResourceNotFoundException;
import com.voting.system.country.Country;
import com.voting.system.constituency.dto.CreateConstituencyRequest;
import com.voting.system.constituency.dto.ConstituencyResponse;
import com.voting.system.constituency.ConstituencyMapper;

@Service 
@Transactional 
public class ConstituencyService {
private final CountryRepository countryRepository;
private final CountyRepistory countyRepistory;
private  final ConstituencyRepository constituencyRepository;
private  final ConstituencyMapper constituencyMapper;


public  ConstituencyService(
CountryRepository countryRepository,CountyRepistory countyRepistory,
ConstituencyRepository constituencyRepository,
ConstituencyMapper constituencyMapper){
    this.countryRepository=countryRepository;
    this.countyRepistory=countyRepistory;
    this.constituencyRepository=constituencyRepository;
    this.constituencyMapper=constituencyMapper;
}
    public  ConstituencyResponse createConstituency(CreateConstituencyRequest request){
        if(constituencyRepository.existsByName(request.name())){
            throw  new RuntimeException("Constituency already exists");
        }
          Country country=countryRepository.findById(request.countryId())
         .orElseThrow(() -> new RuntimeException("Country does not exist"));
         County county=countyRepistory.findById(request.countyId())
         .orElseThrow(()->new RuntimeException("county does not exist"));

         Constituency constituency=constituencyMapper.toEntity(request);
         constituency.setCountry(country);
         constituency.setCounty(county);
         Constituency saved=constituencyRepository.save(constituency);

         return  constituencyMapper.toResponse(saved);

    }

    public  List<ConstituencyResponse> findAllConstituencies(){
        return constituencyRepository.findAll()
        .stream()
        .map(constituencyMapper::toResponse)
        .toList();
    }
    public ConstituencyResponse findConstituencyById(UUID id){
        Constituency constituency=constituencyRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("constituency does not exist"));
        return constituencyMapper.toResponse(constituency);


    }


    public void deleteConstituency(UUID id){
        if(!constituencyRepository.existsById(id)){
            throw new ResourceNotFoundException("Constituency does not exist");
        }
        constituencyRepository.deleteById(id);;
    }
}