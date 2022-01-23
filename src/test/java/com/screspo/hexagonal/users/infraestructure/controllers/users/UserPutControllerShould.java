package com.screspo.hexagonal.users.infraestructure.controllers.users;

import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.exceptions.UserNotFoundException;
import com.screspo.hexagonal.users.application.use_cases.update_user.UserEditor;
import com.screspo.hexagonal.users.mothers.UserDTOMother;
import com.screspo.hexagonal.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;


class UserPutControllerShould {

    @InjectMocks
    private static UserPutController userPutController;

    @Mock
    private static UserEditor userEditor;

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
    void throw_a_response_status_exception_with_http_status_conflict() {
        ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class,
                () -> userPutController.index(UserDTOMother.random(), "invalid-id"));
        assertEquals(HttpStatus.CONFLICT, responseStatusException.getStatus());
    }

    @Test
    void response_with_http_status_ok() {
        doNothing().when(userEditor).edit(any(UserDTO.class));
        ResponseEntity<Void> response = userPutController.index(UserDTOMother.random(), UserDTOMother.random().id());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}