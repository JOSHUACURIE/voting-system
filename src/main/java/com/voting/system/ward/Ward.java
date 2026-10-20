package com.voting.system.ward;

import java.util.UUID;

import com.voting.system.competition.Competition;
import com.voting.system.constituency.Constituency;
import com.voting.system.country.Country;
import  com.voting.system.county.County;
import com.voting.system.aspirants.Aspirants;

import jakarta.persistence.Column;
import  jakarta.persistence.Entity;
import  jakarta.persistence.Id;
import java.time.Instant;
import jakarta.persistence.Table;
import  jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.Instant;
import  java.util.List;
import  jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import  jakarta.persistence.ManyToOne;
@Entity 
@Table(name="ward")
public class Ward {
@Id 
@GeneratedValue(strategy =GenerationType.UUID)
private  UUID id;


private String name;


private  Long registeredVoters;

@ManyToOne(fetch =FetchType.LAZY )
@JoinColumn(name = "country_id",nullable = false)
private  Country country;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "county_id",nullable = false)
private County county;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name ="constituency_id")
private Constituency constituency;

 @Column(name = "created_at")
private  Instant createdAt;
@Column (name = "updated_at")
private Instant updatedAt;

//children
@OneToMany(mappedBy = "ward")
private List<Aspirants>aspirants;
@OneToMany(mappedBy = "ward")
private List<Competition>competititors;

public  void setId(UUID id){
    this.id=id;
}
public  UUID getId(){
    return  id;
}

public void setName(String name){
    this.name=name;
}
public  String getName(){
    return name;
}
public void setRegisteredVoters(Long registeredVoters){
this.registeredVoters=registeredVoters;
}
public  Long getRegisteredVoters(){
    return  registeredVoters;
}

public  void setCountry(County county){
    this.county=county;
}
public County getCounty(){
    return county;
}

public void setCountry(Country country){
    this.country=country;
}
public Country getCountry(){
    return country;
}
    
public void setConstituency(Constituency constituency){
    this.constituency=constituency;
}
public Constituency getConstituency(){
    return  constituency;
}
public void setCreatedAt(Instant createdAt){
    this.createdAt=createdAt;
}
public Instant getCreatedAt(){
    return  createdAt;
}

public void  setUpdatedAt(Instant updatedAt){
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