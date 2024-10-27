package edu.icet.controller;

import edu.icet.dto.MedicalReport;
import edu.icet.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/medical-report")
@RequiredArgsConstructor
public class MedicalReportController {

    final MedicalReportService service;
    @PostMapping("/add-report")
    public void addMedicalReport(@RequestBody MedicalReport medicalReport){
        service.addMedicalReport(medicalReport);
    }
    @GetMapping("/get-all-reports")
    public List<MedicalReport> getMedicalReport(){
        return service.getPatient();
    }
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping("/search-by-category/{category}")
    public List<MedicalReport> searchByCategory(@PathVariable String category){
        return service.searchByCategory(category);
    }
}
