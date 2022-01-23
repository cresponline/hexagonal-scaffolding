package com.screspo.hexagonal.users.infraestructure.controllers.users;

import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.exceptions.UserNotFoundException;
import com.screspo.hexagonal.users.application.use_cases.update_user.UserEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/users/{id}")
public class UserPutController {

    private final UserEditor userEditor;

    public UserPutController(UserEditor userEditor) {
        this.userEditor = userEditor;
    }


    @PutMapping
    public ResponseEntity<Void> index(@RequestBody UserDTO userDTO, @PathVariable String id) {
        try {
            if (!id.equalsIgnoreCase(userDTO.id())) throw new ResponseStatusException(HttpStatus.CONFLICT);
            userEditor.edit(userDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
