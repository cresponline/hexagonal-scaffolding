package com.screspo.hexagonal.users.infraestructure.controllers;

import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.exceptions.UserNotFoundException;
import com.screspo.hexagonal.users.application.use_cases.find_user.UserSearcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/users/{id}")
public class UserGetController {

    private final UserSearcher userSearcher;

    public UserGetController(UserSearcher userSearcher) {
        this.userSearcher = userSearcher;
    }

    @GetMapping
    public ResponseEntity<UserDTO> index(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userSearcher.search(id));
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
