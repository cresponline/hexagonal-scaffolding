package com.screspo.hexagonal.users.infraestructure.controllers;

import com.screspo.hexagonal.users.application.exceptions.UserNotFoundException;
import com.screspo.hexagonal.users.application.use_cases.find_user.UserSearcher;
import com.screspo.hexagonal.users.infraestructure.controllers.users.UserGetController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

class UserGetControllerShould {

    @InjectMocks
    private static UserGetController userGetController;

    @Mock
    private static UserSearcher userSearcher;

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
    void throw_response_status_exception_when_user_not_found() {
        doThrow(UserNotFoundException.class)
                .when(userSearcher)
                .search(anyString());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> userGetController.index(""));

        assertEquals(HttpStatus.NO_CONTENT, exception.getStatus());
    }
}