package com.screspo.hexagonal.users.infraestructure.controllers;

import com.screspo.hexagonal.users.application.delete.UserRemover;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users/{id}")
public class UserDeleteController {

    private final UserRemover userRemover;

    public UserDeleteController(UserRemover userRemover) {
        this.userRemover = userRemover;
    }

    @DeleteMapping
    public ResponseEntity<Void> index(@PathVariable String id) {
        userRemover.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
