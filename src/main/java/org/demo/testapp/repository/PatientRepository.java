package org.demo.testapp.repository;

import org.demo.testapp.model.Patient;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByWhenRegisteredIsNotNull();

    List<Patient> findByWhenInvitedIsNotNull();

    List<Patient> findByWhenDischargedIsNotNull();

    Patient findByEntityId(Long entityId);

    // for test support

    void deleteAll();

    long countPatientByWhenRegisteredIsNotNull();

    long countPatientByWhenInvitedIsNotNull();

    long countPatientByWhenDischargedIsNotNull();
}
