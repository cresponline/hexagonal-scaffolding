package com.screspo.hexagonal.users.infraestructure.controllers;

import com.screspo.hexagonal.users.application.all_users.AllUsersSearcher;
import com.screspo.hexagonal.users.application.dtos.UsersResponse;
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
    public ResponseEntity<UsersResponse> index() {
        return ResponseEntity.ok(allUsersSearcher.search());
    }

}
