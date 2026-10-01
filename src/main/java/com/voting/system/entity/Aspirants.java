package com.voting.system.entity;

import  jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import  jakarta.persistence.Table;
import  jakarta.persistence.Column;
import  jakarta.persistence.Enumerated;
import  jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import  jakarta.persistence.GenerationType;
import  jakarta.persistence.GeneratedValue;
import  jakarta.persistence.FetchType;
import  java.util.UUID;

import java.time.Instant;

@Entity 
@Table(name = "aspirants")
public  class Aspirants{
    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    private  UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private  User userId;

    private  Long age;

    private  String previous_occupation;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="position_id",nullable = false)
    private Position positionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "country_id",nullable = false)
    private Country country;

@Enumerated (EnumType.STRING)
@Column(name = "role")
private  RoleEnum role;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn (name = "county_id",nullable = false)
private County county;


@ManyToOne(fetch = FetchType.LAZY)
@Column(name = "constituency_id")
private  Constituency constituency;

@OneToOne(fetch = FetchType.LAZY)
@Column(name = "ward_id")
private  Ward ward;


@OneToOne(fetch = FetchType.LAZY)
@Column(name = "political_party_id")
private  PoliticalParties partyId;

private  String nextOfKinIdNumber;

@Enumerated (EnumType.STRING)
@Column(name = "application_status")
private  ApplicationStatus applicationStatus;


@Column(name ="profile_picture")
private  String profilePicture;

private Instant createdAt;
private Instant updatedAt;  



//setters and getters
public  void setId(UUID id){
    this.id=id;
}
public  UUID getId(){
    return  id;
}

public void setAge(Long age){
    this.age=age;
}
public  Long getAge(){
    return  age;
}

public  void setPreviousOccupation(String previous_occupation){
    this.previous_occupation=previous_occupation;
}
public String getPreviousOccupation(){
    return  previous_occupation;
}

public  void setPositionId(Position positionId){
    this.positionId=positionId;
}
public  Position getPositionId(){
    return  positionId;
}
public  void setUserId(User userId){
    this.userId=userId;
}
public  User getUserId(){
    return  userId;
}
public  void setCountryId(Country countryId){
    this.country=countryId;
}
public  Country getCountryId(){
    return  country;
}

public void setRole(RoleEnum role){
    this.role=role;
}
public  RoleEnum getRole(){
    return  role;
}

public void setCountyId(County countyId){
    this.county=countyId;
}
public County getCountyId(){
    return county;
}

public void  setConstituencyId(Constituency constituency){
    this.constituency=constituency;
}

public  Constituency getConstituencyId(){
    return constituency;
}

public void setWardId(Ward wardId){
    this.ward=wardId;
}

public  Ward getWardId(){
    return  ward;
}

public void setNextOfKin(String nextOfKinIdNumber){
    this.nextOfKinIdNumber=nextOfKinIdNumber;
}
public  String getNextOfKinIdNumber(){
    return  nextOfKinIdNumber;
}

public void setCreatedAt(Instant createdAt){
this.createdAt=createdAt;
}
public Instant getCreatedAt(){
    return  createdAt;
}

public  void setUpdatedAt(Instant updatedAt){
    this.updatedAt=updatedAt;
}
public  Instant getUpdatedAt(){
    return updatedAt;
}









}