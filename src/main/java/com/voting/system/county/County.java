package com.voting.system.county;
import java.util.UUID;

import com.voting.system.competition.Competition;
import com.voting.system.constituency.Constituency;
import com.voting.system.country.Country;
import com.voting.system.aspirants.Aspirants;
import com.voting.system.ward.Ward;


import jakarta.persistence.Column;
import  jakarta.persistence.Entity;
import  jakarta.persistence.Id;
import java.time.Instant;
import java.util.List;
import  jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity 
@Table(name = "county")
public class County {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private  String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "country_id")
    private Country country;


    @Column(name = "registered_voters")
    private  Long registeredVoters;


    @Column(name = "created_at") 
    private Instant createdAt;

    @Column(name = "updated_at")
    private  Instant updatedAt;


    //children relationships
@OneToMany(mappedBy = "county")
private List<Aspirants>aspirants;
@OneToMany(mappedBy = "county")
private List<Competition>competitors;

@OneToMany (mappedBy = "county")
private List<Constituency>constituencies;

@OneToMany (mappedBy = "county")
private List<Ward>wards;

    //setters and getters
    public void setId(UUID id){
        this.id=id;
    }
    public  UUID getId(){
        return  id;
    }
    public  void setName(String name){
        this.name=name;
    }
    public  String getName(){
        return  name;
    }
    
    public void setCountry(Country country){
        this.country=country;
    }
    public  Country getCountry(){
        return  country;
    }
    public  void setRegisteredVoters(Long registeredVoters){
        this.registeredVoters=registeredVoters;
    }
    public void setCreatedAt(Instant createdAt){
        this.createdAt=createdAt;
    }
    public  Instant getCreatedAt(){
        return  createdAt;

    }


    public void setUpdatedAt(Instant updatedAt){
        this.updatedAt=updatedAt;
    }
    public  Instant getUpdatedAt(){
        return  updatedAt;
    }

    //instant timestamping
    @jakarta.persistence.PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @jakarta.persistence.PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

}