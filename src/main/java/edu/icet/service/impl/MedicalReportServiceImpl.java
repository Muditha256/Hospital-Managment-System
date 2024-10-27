package edu.icet.service.impl;

import edu.icet.dto.MedicalReport;
import edu.icet.entity.MedicalReportEntity;
import edu.icet.repository.MedicalReportRepository;
import edu.icet.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalReportServiceImpl implements MedicalReportService {

    final ModelMapper mapper;
    final MedicalReportRepository repository;
    @Override
    public void addMedicalReport(MedicalReport medicalReport) {
        repository.save(mapper.map(medicalReport,MedicalReportEntity.class));
    }

    @Override
    public List<MedicalReport> getPatient() {
        List<MedicalReport>medicalReports = new ArrayList<>();
        repository.findAll().forEach(medicalReport->{
            medicalReports.add(mapper.map(medicalReport,MedicalReport.class));
        });
        return medicalReports;

    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<MedicalReport> searchByCategory(String category) {
        List<MedicalReport> medicalReportsList = new ArrayList<>();
        repository.findByCategory(category).forEach(entity->{
           medicalReportsList.add( mapper.map(entity, MedicalReport.class));
        });
        return medicalReportsList;
    }
}
