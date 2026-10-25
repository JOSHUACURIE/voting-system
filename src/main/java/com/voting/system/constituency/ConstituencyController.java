package com.voting.system.constituency;


import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.voting.system.constituency.dto.*;
import  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/constituency")
public class ConstituencyController {
private final ConstituencyService constituencyService;    

public ConstituencyController(ConstituencyService constituencyService){
    this.constituencyService=constituencyService;
}
@PostMapping("/create")
public ResponseEntity<ConstituencyResponse>create(@Valid  @RequestBody CreateConstituencyRequest request){
    ConstituencyResponse response=constituencyService.createConstituency(request);
    return  ResponseEntity.status(HttpStatus.CREATED).body(response);
}

}
