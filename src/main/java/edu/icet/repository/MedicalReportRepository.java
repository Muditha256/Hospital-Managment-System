package edu.icet.repository;

import edu.icet.entity.MedicalReportEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicalReportRepository extends CrudRepository<MedicalReportEntity,Integer> {
    List<MedicalReportEntity> findByCategory(String category);
}
