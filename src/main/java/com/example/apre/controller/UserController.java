package com.example.apre.controller;

import com.example.apre.entity.User;
import com.example.apre.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        log.info("Inicia guardado de usuario");

        try {
            // Verificar si el correo ya existe
            Optional<User> existingUserByEmail = userService.findByEmail(user.getEmail());
            if (existingUserByEmail.isPresent()) {
                log.info("El correo ya existe: " + user.getEmail());
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El correo ya está en uso");
            }

            // Verificar si el nombre de usuario ya existe
            Optional<User> existingUserByUsername = userService.findByUsername(user.getUsername());
            if (existingUserByUsername.isPresent()) {
                log.info("El nombre de usuario ya existe: " + user.getUsername());
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El nombre de usuario ya está en uso");
            }

            // Asignar un UUID al usuario
            user.setId(UUID.randomUUID());
            log.info("id: " + user.getId());

            // Guardar el usuario
            User createdUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

        } catch (Exception e) {
            log.error("Error al guardar el usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el usuario");
        }
    }
}