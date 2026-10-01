package com.voting.system.entity;

import  jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import  jakarta.persistence.Table;
import  jakarta.persistence.Column;
import  jakarta.persistence.Enumerated;
import  jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import  jakarta.persistence.GenerationType;
import  jakarta.persistence.GeneratedValue;
import  jakarta.persistence.FetchType;
import  java.util.UUID;
import  java.time.LocalDateTime;


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

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name="position_id",nullable = false)
    private Position positionId;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "country_id",nullable = false)
    private Country countryId;

@Enumerated (EnumType.STRING)
@Column(name = "role")
private  RoleEnum role;

@OneToOne(fetch = FetchType.LAZY)
@Column(name = "county_id")
private County countyId;


@OneToOne(fetch = FetchType.LAZY)
@Column(name = "constituency_id")
private  Constituency constituency;

@OneToOne(fetch = FetchType.LAZY)
@Column(name = "ward_id")
private  Ward waidId;


@OneToOne(fetch = FetchType.LAZY)
@Column(name = "political_party_id")
private  PoliticalParties partyId;

private  String nextOfKinIdNumber;

@Enumerated (EnumType.STRING)
@Column(name = "application_status")
private  ApplicationStatus applicationStatus;


@Column(name ="profile_picture")
private  String profilePicture;

private LocalDateTime createdAt;
private LocalDateTime updatedAt;  



//setters and getters










}