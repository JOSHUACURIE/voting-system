package com.voting.system.ward;

import com.voting.system.country.CountryRepository;
import com.voting.system.county.CountyRepistory;
import com.voting.system.constituency.ConstituencyRepository;
import com.voting.system.ward.dto.CreateWardRequest;
import com.voting.system.common.exception.ResourceNotFoundException;
import com.voting.system.ward.dto.WardResponse;

import java.util.List;
import java.util.UUID;
import com.voting.system.country.Country;
import com.voting.system.county.County;
import com.voting.system.constituency.Constituency;


import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;





@Service 
@Transactional 
public class WardService {
    private  final CountryRepository countryRepository;
    private final CountyRepistory countyRepistory;
    private final ConstituencyRepository constituencyRepository;
    private final WardRepository wardRepository;
    private final WardMapper wardMapper;

    public WardService(CountryRepository countryRepository,CountyRepistory countyRepistory,ConstituencyRepository constituencyRepository,
        WardRepository wardRepository,WardMapper wardMapper
    ){
        this.countryRepository=countryRepository;
        this.countyRepistory=countyRepistory;
        this.wardRepository=wardRepository;
        this.constituencyRepository=constituencyRepository;
        this.wardMapper=wardMapper;
    }


public WardResponse createWard(CreateWardRequest request){
if(wardRepository.existsByName(request.name())){
    throw new RuntimeException("Ward already exists");
}

Country country=countryRepository.findById(request.countryId())
.orElseThrow(()->new ResourceNotFoundException("Country does not exists"));

County county=countyRepistory.findById(request.countyId())
.orElseThrow(()-> new ResourceNotFoundException("County does not exists"));

Constituency constituency=constituencyRepository.findById(request.constituencyId())
.orElseThrow(()->new  ResourceNotFoundException("constituency not found"));


Ward ward=wardMapper.toEntity(request);
ward.setCountry(country);
ward.setConstituency(constituency);
ward.setCounty(county);

Ward saved=wardRepository.save(ward);

return  wardMapper.toResponse(saved);
}

public List<WardResponse>findAllWards(){
    return wardRepository.findAll()
    .stream()
    .map(wardMapper::toResponse)
    .toList();
}

public WardResponse findWardById(UUID id){
Ward ward=wardRepository.findById(id)
.orElseThrow(()->new ResourceNotFoundException("ward not found"));

return wardMapper.toResponse(ward);
}

}
