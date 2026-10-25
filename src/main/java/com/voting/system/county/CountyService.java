package com.voting.system.county;

import com.voting.system.county.dto.CountyResponse;
import com.voting.system.county.dto.CreateCountyRequest;
import com.voting.system.county.County;
import com.voting.system.county.CountyRepistory;
import com.voting.system.county.CountyMapper;
public class CountyService {

private CountyRepistory countyRepistory;
private CountyMapper countyMapper;

public CountyService(CountyRepistory countyRepistory,CountyMapper countyMapper){
    this.countyRepistory=countyRepistory;
    this.countyMapper=countyMapper;
}
    

public CountyResponse createCounty(CreateCountyRequest request){
    if(countyRepistory.existsByName(request.name())){
        throw new RuntimeException("County already exists");
    }
    County county=countyMapper.toEntity(request);
    County saved=countyRepistory.saveAndFlush(county);

    return  countyMapper.toResponse(saved);
}
}
