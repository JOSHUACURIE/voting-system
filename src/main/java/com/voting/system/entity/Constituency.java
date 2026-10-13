package com.voting.system.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import  jakarta.persistence.Entity;
import  jakarta.persistence.Id;
import java.time.Instant;
import  jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity 
public  class Constituency {
        @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column (name = "id",updatable = false,nullable = false)
    private  UUID id;


    @Column(name = "name",updatable = true,nullable = false)
    private String name;

  
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "country_id",nullable = false)
    private  Country country;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "county_id",nullable = false)
    private County county;

    @Column (name = "registered_voters")
    private Long registeredVoters;

    @Column (name = "created_at")
    private Instant createdAt;

    @Column (name = "updated_at")
    private  Instant updatedAt;

    
    //relationships..children


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
        return name;
    }
    
    public void setCountry(Country country){
        this.country=country;
    }
    public  Country getCountry(){
        return  country;
    }
    public  void setCounty(County county){
        this.county=county;
    }
    public  County getCounty(){
        return  county;
    
    }
    public  void setRegisteredVoters(Long registeredVoters){
        this.registeredVoters=registeredVoters;
    }
    public  Long getRegisteredVoters(){
        return  registeredVoters;
     }
 
    public  void setCreatedAt(Instant createdAt){
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