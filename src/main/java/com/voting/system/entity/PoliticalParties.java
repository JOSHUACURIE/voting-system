package com.voting.system.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import  jakarta.persistence.Entity;
import  jakarta.persistence.Id;
import java.time.Instant;
import  jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity 
@Table(name = "political_parties")
public  class PoliticalParties {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    private String motto;
    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "party_leader")
    private String partyLeader;

    @Column(name = "deputy_party_leader")
    private String dPartyLeader;

    @Column(name = "national_chairperson")
    private String nChairperson;

    private String description;
    @Column(name = "registration_cert_url")
    private String regCertUrl;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    //setters and getters


    
}