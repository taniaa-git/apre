package com.example.apre.service;
import com.example.apre.entity.Appointment;
import java.util.List;
public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> findAll();
}
