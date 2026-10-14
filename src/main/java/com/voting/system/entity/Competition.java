package com.voting.system.entity;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import  jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import  jakarta.persistence.Id;
import java.time.Instant;
import  jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity 
@Table (name = "competition")
public  class Competition {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  UUID id;

    @Enumerated (EnumType.STRING)
    @Column(name = "position")
    private PositionEnum position;

    @ManyToOne 
    @JoinColumn(name = "country_id",nullable = true)
    private Country country;

    @ManyToOne 
    @JoinColumn(name="county_id",nullable = true)
    private County county; 

    @ManyToOne 
    @JoinColumn(name = "constituency_id",nullable = true)
    private  Constituency constituency;

    @ManyToOne
    @JoinColumn(name = "ward_id",nullable = false)
    private  Ward ward;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private  Instant updatedAt;

//children
@OneToMany(mappedBy = "competition")
private  List<Aspirants>aspirants;
    //setters and getters
    
    
}