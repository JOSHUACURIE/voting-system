package com.voting.system.constituency;


import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.voting.system.constituency.dto.*;

import java.util.List;
import java.util.UUID;

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
@GetMapping("/all")
public ResponseEntity<List<ConstituencyResponse>>getAll(){
    return ResponseEntity.ok(constituencyService.findAllConstituencies());
}

@GetMapping("/{id}")
public ResponseEntity<ConstituencyResponse>findById(@PathVariable  UUID id){
    return ResponseEntity.ok(constituencyService.findConstituencyById(id));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void>deleteConstituency(@PathVariable UUID id){
    constituencyService.deleteConstituency(id);
    return ResponseEntity.noContent().build();
}
}
