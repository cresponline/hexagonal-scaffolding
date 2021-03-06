package com.screspo.hexagonal.users.infraestructure.controllers.users;


import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.exceptions.UserAlreadyExistsException;
import com.screspo.hexagonal.users.application.use_cases.create.UserCreator;
import com.screspo.hexagonal.users.mothers.UserDTOMother;
import org.junit.jupiter.api.AfterEach;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

class UserPostControllerTest {

    @InjectMocks
    private static UserPostController userPostController;

    @Mock
    private static UserCreator userCreator;

    private AutoCloseable closeable;

    private final UserDTO userDTO = UserDTOMother.random();

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @Test
    void shouldRespondsWithCreatedStatusCode() {
        doNothing().when(userCreator).create(userDTO);
        ResponseEntity<Void> response = userPostController.index(userDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void mustThrowResponseStatusExceptionWhenUserAlreadyExists() {
        doThrow(UserAlreadyExistsException.class)
                .when(userCreator)
                .create(userDTO);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> userPostController.index(userDTO));
        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
    }
}