package com.voting.system.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import  jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import  jakarta.persistence.Id;
import java.time.Instant;
import  jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity 
public  class Officers {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  User user;

    @Column(name = "staff_number")
    private String staffNumber;

    @Enumerated(EnumType.STRING)
    @Column (name = "role",nullable = false)
    private RoleEnum role;

    private String designation;

    private String department;

    @Column (name = "id_number")
    private  String idNumber;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    //setter and getter methods
    public void setId(UUID id){
        this.id=id;
    }
    public  UUID getId(){
        return id;
    }
     

    public  void setUser(User user){
        this.user=user;
    }
    public  User getUser(){
        return user;
    }
    public void setStaffNumber(String staffNumber){
        this.staffNumber=staffNumber;
    }
}