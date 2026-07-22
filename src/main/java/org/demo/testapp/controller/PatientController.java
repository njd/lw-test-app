package org.demo.testapp.controller;

import org.demo.testapp.dto.PatientResponseDto;
import org.demo.testapp.mapper.PatientResponseMapper;
import org.demo.testapp.model.Patient;
import org.demo.testapp.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private PatientRepository patientRepository;
    private PatientResponseMapper patientResponseMapper;

    public PatientController(PatientRepository patientRepository, PatientResponseMapper patientResponseMapper) {
        this.patientRepository = patientRepository;
        this.patientResponseMapper = patientResponseMapper;
    }

    @GetMapping("/list")
    public String listPatients() {

        List<Patient> patients = patientRepository.findAll();

        List<PatientResponseDto> patientDtos = patientResponseMapper.
                toDtoList(patients);

        return "list";
    }
}
