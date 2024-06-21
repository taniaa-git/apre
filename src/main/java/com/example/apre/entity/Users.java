package com.example.apre.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private int role;

    public Users() {
    }
}
