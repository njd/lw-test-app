package org.demo.testapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {

    @Id
    // @GeneratedValue(strategy = GenerationType.)
    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @Size(max = 255)
    @Column(name = "nhs_number")
    private String nhsNumber;

    @Size(max = 255)
    @Column(name = "hospital_id")
    private String hospitalId;

    @Size(max = 255)
    @NotNull
    @Column(name = "given_name", nullable = false)
    private String givenName;

    @Size(max = 255)
    @Column(name = "gender")
    private String gender;

    @Size(max = 255)
    @NotNull
    @Column(name = "family_name", nullable = false)
    private String familyName;

    @Column(name = "when_registered")
    private LocalDateTime whenRegistered;

    @NotNull
    @Column(name = "when_invited", nullable = false)
    private LocalDateTime whenInvited;

    @Column(name = "when_discharged")
    private LocalDateTime whenDischarged;

    @Version
    @NotNull
    @Column(name = "entity_version", nullable = false)
    private Long entityVersion;

    @NotNull
    @Column(name = "entity_updated", nullable = false)
    private Instant entityUpdated;

    @NotNull
    @Column(name = "entity_created", nullable = false)
    private Instant entityCreated;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Patient(String title, String givenName, String familyName) {
        this.title = title;
        this.givenName = givenName;
        this.familyName = familyName;
    }
}
