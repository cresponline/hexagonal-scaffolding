package com.screspo.hexagonal.users.infraestructure.controllers;

import com.screspo.hexagonal.users.application.create.UserCreator;
import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.exceptions.UserAlreadyExistsException;
import com.screspo.hexagonal.users.mothers.UserDTOMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

class UserPostControllerShould {

    @InjectMocks
    private static UserPostController userPostController;

    @Mock
    private static UserCreator userCreator;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        doNothing().when(userCreator).create(any(UserDTO.class));

    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void throw_response_status_exception_when_user_already_exists() {
        doThrow(UserAlreadyExistsException.class)
                .when(userCreator)
                .create(any(UserDTO.class));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> userPostController.index(UserDTOMother.random()));

        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
    }


}