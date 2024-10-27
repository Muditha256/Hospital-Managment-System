package edu.icet.service.impl;

import edu.icet.dto.Appointment;
import edu.icet.dto.Patient;
import edu.icet.entity.AppointmentEntity;
import edu.icet.repository.AppointmentRepository;
import edu.icet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    final AppointmentRepository repository;
    final ModelMapper mapper;

    @Override
    public void addAppointment(Appointment appointment) {
        log.info(appointment.toString());
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }

    @Override
    public Boolean deleteById(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Appointment> searchByAdminId(Integer id) {
        List<Appointment> appointment = new ArrayList<>();
        repository.findByAdminId(id).forEach(entity ->{
            appointment.add(mapper.map(entity,Appointment.class));
        });

        return appointment;
    }

    @Override
    public List<Appointment> searchByPatientId(Integer id) {
        List<Appointment> appointment = new ArrayList<>();
        repository.findByPatientId(id).forEach(entity ->{
            appointment.add(mapper.map(entity,Appointment.class));
        });
        return appointment;
    }

    @Override
    public List<Appointment> searchByType(String type) {
        List<Appointment> appointment = new ArrayList<>();
        repository.findByType(type).forEach(entity ->{
            appointment.add(mapper.map(entity,Appointment.class));
        });
        return appointment;
    }


}
