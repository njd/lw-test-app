package org.demo.testapp.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.demo.testapp.dto.PatientResponseDto;
import org.demo.testapp.mapper.ActionMapper;
import org.demo.testapp.mapper.PatientResponseMapper;
import org.demo.testapp.model.Patient;
import org.demo.testapp.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    private PatientRepository patientRepository;
    private PatientResponseMapper patientResponseMapper;
    private ActionMapper actionMapper;

    public PatientService(PatientRepository patientRepository,
                          PatientResponseMapper patientResponseMapper,
                          ActionMapper actionMapper) {
        this.patientRepository = patientRepository;
        this.patientResponseMapper = patientResponseMapper;
        this.actionMapper = actionMapper;
    }

    public PatientResponseDto getPatient(Long entityId) throws PatientNotFoundException {
        Optional<Patient> patient = patientRepository.findByEntityId(entityId);

        return patient.map(patientResponseMapper::toDto)
                .orElseThrow(() -> new PatientNotFoundException(entityId));

    }

    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientResponseMapper.toDtoList(patients);
    }

    public List<PatientResponseDto> getPatientsRegistered() {
        List<Patient> patients = patientRepository.findByWhenRegisteredIsNotNull();
        return patientResponseMapper.toDtoList(patients);
    }

    public List<PatientResponseDto> getPatientsInvited() {
        List<Patient> patients = patientRepository.findByWhenInvitedIsNotNull();
        return patientResponseMapper.toDtoList(patients);
    }

    public List<PatientResponseDto> getPatientsDischarged() {
        List<Patient> patients = patientRepository.findByWhenDischargedIsNotNull();
        return patientResponseMapper.toDtoList(patients);
    }
}
