package com.voting.system.voters;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "voters")
public class Voters {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // ... rest
}