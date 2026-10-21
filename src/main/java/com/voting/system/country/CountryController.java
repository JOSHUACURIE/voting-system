package com.voting.system.country;
import org.springframework.web.bind.annotation.*;
import  com.voting.system.country.dto.CountryResponse;
import  com.voting.system.country.dto.CreateCountryRequest;
import com.voting.system.country.CountryRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import  java.util.List;
import  java.util.UUID;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/country")
public class CountryController {
    private  final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService=countryService;
    }
    

    @PostMapping("/register")
    public ResponseEntity<CountryResponse>register(@Valid @RequestBody CreateCountryRequest request){
        CountryResponse res=countryService.createCountry(request);

        return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<CountryResponse>>getAll(){

        return  ResponseEntity.ok(countryService.findAllCountries());
    }

    @GetMapping("/:id")
    public  ResponseEntity<CountryResponse>findById(@PathVariable UUID id){
        return  ResponseEntity.ok(countryService.findCountryById(id));

    }
}
