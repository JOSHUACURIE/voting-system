package com.voting.system.county;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;
import com.voting.system.county.dto.CountyResponse;
import com.voting.system.county.dto.CreateCountyRequest;
import org.springframework.web.bind.annotation.*;

import com.voting.system.country.CountryController;
import com.voting.system.country.CountryService;

import  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController 
@RequestMapping("/api/county")
public class CountyController {
    private  final CountyService countyService;

    public CountyController(CountyService countyService){
        this.countyService=countyService;
    }
@PostMapping("/create")
public ResponseEntity<CountyResponse>register(@Valid @RequestBody CreateCountyRequest request){
    CountyResponse response=countyService.createCounty(request);
    return  ResponseEntity.status(HttpStatus.CREATED).body(response);
}

@GetMapping("/all")
public ResponseEntity <List<CountyResponse>>getAll(){
return ResponseEntity.ok(countyService.getAllCounties());
}
    
}
