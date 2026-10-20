package com.voting.system.aspirants;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import com.voting.system.enums.*;
import com.voting.system.constituency.Constituency;
import com.voting.system.ward.Ward;
import com.voting.system.users.User;
import com.voting.system.country.Country;
import com.voting.system.politicalparties.PoliticalParties;
import com.voting.system.county.County;
import com.voting.system.competition.Competition;
@Entity 
@Table(name = "aspirants")
public class Aspirants {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // 1. User linking: ONE user can register as ONE aspirant profile
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private Long age;

    @Column(name = "previous_occupation")
    private String previousOccupation;

    // 2. Link to Competition (Contest/Race)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    // 3. Optional: Direct position reference (if needed alongside competition)
    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private PositionEnum position;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    // 4. Geographical links (ALL MUST BE NULLABLE for national/county candidates)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = true)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "county_id", nullable = true)
    private County county;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constituency_id", nullable = true)
    private Constituency constituency;

    // Fixed: Changed from @OneToOne to @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id", nullable = true)
    private Ward ward;

    // Fixed: Changed from @OneToOne to @ManyToOne (many aspirants belong to 1 party)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "political_party_id")
    private PoliticalParties party;

    @Column(name = "next_of_kin_id_number")
    private String nextOfKinIdNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    private ApplicationStatus applicationStatus;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    // ==========================================
    // GETTERS & SETTERS
    // ==========================================

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Long getAge() { return age; }
    public void setAge(Long age) { this.age = age; }

    public String getPreviousOccupation() { return previousOccupation; }
    public void setPreviousOccupation(String previousOccupation) { this.previousOccupation = previousOccupation; }

    public Competition getCompetition() { return competition; }
    public void setCompetition(Competition competition) { this.competition = competition; }

    public PositionEnum getPosition() { return position; }
    public void setPosition(PositionEnum position) { this.position = position; }

    public RoleEnum getRole() { return role; }
    public void setRole(RoleEnum role) { this.role = role; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    public County getCounty() { return county; }
    public void setCounty(County county) { this.county = county; }

    public Constituency getConstituency() { return constituency; }
    public void setConstituency(Constituency constituency) { this.constituency = constituency; }

    public Ward getWard() { return ward; }
    public void setWard(Ward ward) { this.ward = ward; }

    public PoliticalParties getParty() { return party; }
    public void setParty(PoliticalParties party) { this.party = party; }

    public String getNextOfKinIdNumber() { return nextOfKinIdNumber; }
    public void setNextOfKinIdNumber(String nextOfKinIdNumber) { this.nextOfKinIdNumber = nextOfKinIdNumber; }

    public ApplicationStatus getApplicationStatus() { return applicationStatus; }
    public void setApplicationStatus(ApplicationStatus applicationStatus) { this.applicationStatus = applicationStatus; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }

    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}