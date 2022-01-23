package com.screspo.hexagonal.users.infraestructure.controllers.users;

import com.screspo.hexagonal.users.application.use_cases.all_users.AllUsersSearcher;
import com.screspo.hexagonal.users.application.dtos.UsersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UsersGetController {

    private final AllUsersSearcher allUsersSearcher;

    public UsersGetController(AllUsersSearcher allUsersSearcher) {
        this.allUsersSearcher = allUsersSearcher;
    }


    @GetMapping
    public ResponseEntity<UsersDTO> index() {
        return ResponseEntity.ok(allUsersSearcher.search());
    }
}
