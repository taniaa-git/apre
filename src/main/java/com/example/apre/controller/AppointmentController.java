package com.example.apre.controller;

import com.example.apre.entity.Appointment;
import com.example.apre.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }
    @GetMapping
    public String user() {
        return "test";
    }
    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment){
        Appointment createAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body("La cita se ha agendado correctamente: " + createAppointment.getAppointmentDate());
    }
}
