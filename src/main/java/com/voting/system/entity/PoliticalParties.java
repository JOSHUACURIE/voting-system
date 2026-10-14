package com.voting.system.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import  jakarta.persistence.Entity;
import  jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Table;

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

    //children
@OneToMany(mappedBy = "party", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Aspirants> aspirants = new ArrayList<>();

    //setters and getters
    public void setId(UUID id){
        this.id=id;
    }
    public UUID getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setMotto(String motto){
     this.motto=motto;
    }
    public  String getMotto(){
        return  motto;
    }
    public  void setLogoUrl(String logoUrl){
        this.logoUrl=logoUrl;
    }
    public String getLogoUrl(){
        return  logoUrl;
    }
    public void setPartyLeader(String partyLeader){
        this.partyLeader=partyLeader;
    }
    public  String getPartyLeader(){
        return  partyLeader;
    }
    public  void setDeputyPartyLeader(String dPartleader){
        this.dPartyLeader=dPartleader;
    }
    public  String getDeputyPartyLeader(){
        return dPartyLeader;
    }
    public void setNationalChairperson(String nChairperson){
        this.nChairperson=nChairperson;
    }
    public String getNationalChairPerson(){
        return  nChairperson;
    }

    public void setPartyDescription(String description){
    this.description=description;
    }
    public String getPartyDescription(){
        return description;
    }
    public  void setRegistrationCertUrl(String regCertUrl){
        this.regCertUrl=regCertUrl;
    }
    public String getRegistrationCertUrl(){
        return regCertUrl;
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