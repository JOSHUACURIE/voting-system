package com.voting.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.Instant;
import java.util.UUID;



@Entity 
@Table (name ="users")
public class User{
    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column (name = "id",updatable = false,nullable = false)
    private  UUID id;

    @Column (name = "email",nullable = false,unique = true)
    private String email;

  
    @Column(name="username",nullable = false,unique = true)
    private String username;

    private  String passwordHash;
    private String passwordSalt;

    private  String firstName;
    private  String middleName;
    private  String lastName;

    @Enumerated (EnumType.STRING)
    @Column(name = "religion")
    private  ReligionEnum religion;

    private String nationality;

    @OneToOne(mappedBy = "users",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private  Aspirants aspirant;

    private  String idNumber;

    private Instant createdAt;

    private  Instant updatedAt;


//setters and getters

public UUID getId(){
    return  id;
}
public void setId(UUID id){
    this.id=id;
}

public void setEmail(String email){
    this.email=email;
}
public  String getEmail(){
return  email;
}

public void setFirstName(String firstName){
    this.firstName=firstName;
}
public  String getFirstName(){
    return  firstName;
}
public  void setMiddleName(String middleName){
    this.middleName=middleName;
}
public  String getMiddleName(){
    return middleName;
}
public  void setLastName(String lastName){
this.lastName=lastName;
}
public  String getLastName(){
    return  lastName;
}


//password related setters and getters
public  void setPasswordHash(String hashedPassword){
this.passwordHash=hashedPassword;
}
public  String getHashedPassword(){
    return  passwordHash;
}

public void setPasswordSalt(String passwordSalt){
    this.passwordSalt=passwordSalt;
}
public String getSaltPassword(){
    return  passwordSalt;
}

public void setNationality(String nationality){
    this.nationality=nationality;
}
public  String getNationality(){
    return  nationality;
}

public  void setCreatedAt(Instant createdAt){
    this.createdAt=createdAt;
}
public  Instant getCreatedAt(){
    return  createdAt;
}

public void setReligion(ReligionEnum religion){
    this.religion=religion;
}
public  ReligionEnum getReligion(){
    return  religion;
}

public void setIdNumber(String idNumber){

this.idNumber=idNumber;
}
public String getIdNumber(){
    return  idNumber;
}

public void setUpdatedAt(Instant updatedAt){
    this.updatedAt=updatedAt;
}
public  Instant getUpdatedAt(){
    return  updatedAt;
}

}