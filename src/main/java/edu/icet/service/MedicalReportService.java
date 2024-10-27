package edu.icet.service;

import edu.icet.dto.MedicalReport;

import java.util.List;

public interface MedicalReportService {
    void addMedicalReport(MedicalReport medicalReport);

    List<MedicalReport> getPatient();

    void deleteById(Integer id);

    List<MedicalReport> searchByCategory(String category);
}
