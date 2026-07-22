package org.demo.testapp.repository;

import org.demo.testapp.model.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @EntityGraph(attributePaths = { "actions" })
    List<Patient> findByWhenRegisteredIsNotNull();

    @EntityGraph(attributePaths = { "actions" })
    List<Patient> findByWhenInvitedIsNotNull();

    @EntityGraph(attributePaths = { "actions" })
    List<Patient> findByWhenDischargedIsNotNull();


    @EntityGraph(attributePaths = { "actions" })
    List<Patient> findAll();

    Optional<Patient> findByEntityId(Long entityId);

    // for test support

    void deleteAll();

    long countPatientByWhenRegisteredIsNotNull();

    long countPatientByWhenInvitedIsNotNull();

    long countPatientByWhenDischargedIsNotNull();
}
