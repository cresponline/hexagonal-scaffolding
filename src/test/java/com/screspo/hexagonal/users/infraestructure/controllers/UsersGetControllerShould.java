package com.screspo.hexagonal.users.infraestructure.controllers;

import com.screspo.hexagonal.users.application.use_cases.all_users.AllUsersSearcher;
import com.screspo.hexagonal.users.application.dtos.UsersDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class UsersGetControllerShould {

    @InjectMocks
    private static UsersGetController usersGetController;

    @Mock
    private static AllUsersSearcher allUsersSearcher;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void usersGetController_should_call_allUsersSearcher() {
        usersGetController.index();
        verify(allUsersSearcher).search();
    }

    @Test
    void usersGetController_should_response_with_HttpStatus_OK() {
        ResponseEntity<UsersDTO> usersResponse = usersGetController.index();
        assertEquals(HttpStatus.OK, usersResponse.getStatusCode());
    }

}