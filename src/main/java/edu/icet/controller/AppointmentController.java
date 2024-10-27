package edu.icet.controller;

import edu.icet.dto.Appointment;
import edu.icet.dto.Patient;
import edu.icet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    final AppointmentService service;

    @PostMapping("/add-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAppointment(@RequestBody Appointment appointment){
        service.addAppointment(appointment);
    }
    @PutMapping("/update-appointment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAppointment(@RequestBody Appointment appointment){
        service.addAppointment(appointment);
    }
    @DeleteMapping("/delete-appointment/{id}")
    public Boolean deleteAppointment(@PathVariable Integer id){
        return service.deleteById(id);
    }

    @GetMapping("/search-by-Admin-id/{id}")
    public List<Appointment> searchByAdminId(@PathVariable Integer id) {
        return service.searchByAdminId(id);
    }

    @GetMapping("/search-by-Patient-id/{id}")
    public List<Appointment> searchByPatientId(@PathVariable Integer id) {
        return service.searchByPatientId(id);
    }

    @GetMapping("/search-by-type/{type}")
    public List<Appointment> searchBytype(@PathVariable String type) {
        return service.searchByType(type);
    }
}
