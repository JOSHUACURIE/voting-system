package com.voting.system.entity;
import  jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.persistence.GeneratedValue;
import  jakarta.persistence.GenerationType;

import java.util.List;
import java.util.UUID;
import  jakarta.persistence.Column;
import  java.time.Instant;



@Entity
@Table (name = "country") 
public  class Country {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    @Column(name="registered_voters")
    private Long registeredVoters;

    @Column (name = "created_at")
    private Instant createdAt;

    @Column (name = "updated_at")
    private  Instant updatedAt;

//bidirectional relationships...owner
@OneToMany(mappedBy = "country")
private List<Aspirants>aspirants;
    //setter and getter methods

    public void setId(UUID id){
        this.id=id;
    }
    public  UUID getId(){
        return  id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return  name;
    }

    public void setRegisteredVoters(Long registeredVoters){
        this.registeredVoters=registeredVoters;
    }
    public Long getRegisterVoters(){
        return registeredVoters;
    }

    public  void setCreatedAt(Instant createdAt){
        this.createdAt=createdAt;
    }
    public Instant getCreatedAt(){
        return  createdAt;
    }
    public  void setUpdatedAt(Instant updatedAt){
        this.updatedAt=updatedAt;
    }
    public Instant getUpdatedAt(){
        return  updatedAt;
    }
    

     
}