package com.example.apre.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "appointments")

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private LocalDate appointmentDate;
    @NotNull
    private String purpose;
/*
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
*/

    public Appointment() {

    }
}
