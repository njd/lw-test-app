package org.demo.testapp.controller;

import org.demo.testapp.dto.PatientResponseDto;
import org.demo.testapp.mapper.ActionMapper;
import org.demo.testapp.mapper.PatientResponseMapper;
import org.demo.testapp.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HomeController {

    PatientResponseMapper patientResponseMapper;
    ActionMapper actionMapper;

    private final PatientService patientService;

    public HomeController(PatientResponseMapper patientResponseMapper,
                          ActionMapper actionMapper, PatientService patientService) {
        this.patientResponseMapper = patientResponseMapper;
        this.actionMapper = actionMapper;
        this.patientService = patientService;
    }


    @GetMapping("/")
    public String listPatients(Model model) {

        List<PatientResponseDto> patientDtos = patientService.getPatients();

        model.addAttribute("datetime", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        model.addAttribute("patients", patientDtos);
        return "list";
    }

    @GetMapping("/registered")
    public String listPatientsRegistered(Model model) {
        model.addAttribute("datetime", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        model.addAttribute("patients", patientService.getPatientsRegistered());
        return "list";
    }

    @GetMapping("/invited")
    public String listPatientsInvited(Model model) {
        model.addAttribute("datetime", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        model.addAttribute("patients", patientService.getPatientsInvited());
        return "list";
    }

    @GetMapping("/discharged")
    public String listPatientsDischarged(Model model) {
        model.addAttribute("datetime", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        model.addAttribute("patients", patientService.getPatientsDischarged());
        return "list";
    }

    @GetMapping("/patient/{id}")
    public String getPatient(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "show";
    }

}
