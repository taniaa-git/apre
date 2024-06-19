package com.example.apre.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter

@Entity
public class Users {
    @Id
    private Long id;
    private String username;
    private String email;
    private String password;
    private int role;

    public Users() {
    }

}
