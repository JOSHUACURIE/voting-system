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

    @Column (name="member_of_parliament")
    private String mp;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "country_id",nullable = false)
    private  Country country;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "county_id",nullable = false)
    private County county;




    
}