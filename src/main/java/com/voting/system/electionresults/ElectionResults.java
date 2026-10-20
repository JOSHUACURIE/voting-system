package com.voting.system.electionresults;


import java.util.UUID;

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
import  jakarta.persistence.Entity;
@Entity 
public  class ElectionResults {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;


    
}