package edu.icet.controller;

import edu.icet.dto.Patient;
import edu.icet.service.PatientService;
import edu.icet.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService service;
    @GetMapping("/get-all")
    public List<Patient> getPatient(){
        return service.getPatient();
    }

    @PostMapping("/add-patient")
    public void addPatient(@RequestBody Patient patient){
        service.addPatient(patient);
    }
}
