package com.example.apre.controller;

import com.example.apre.entity.Appointment;
import com.example.apre.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:63342") // Configuración CORS
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }
/*
    @GetMapping
    public String user() {
        return "test";
    }
*/
@GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        return ResponseEntity.ok(appointments);
    }
    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment){
        Appointment createAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body("La cita se ha agendado correctamente: " + createAppointment.getAppointmentDate());
    }
}
