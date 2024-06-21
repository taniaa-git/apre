package com.example.apre.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter

@Entity
@Table(name = "users")
public class User {
    @Id // Para MySQL usando AUTO_INCREMENT
    private UUID id;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private int role;

    public User() {
    }

}
