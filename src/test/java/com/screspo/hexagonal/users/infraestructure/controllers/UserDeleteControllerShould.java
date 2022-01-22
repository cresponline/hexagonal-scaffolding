package com.screspo.hexagonal.users.infraestructure.controllers;

import com.screspo.hexagonal.users.application.use_cases.delete.UserRemover;
import com.screspo.hexagonal.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

class UserDeleteControllerShould {

    @InjectMocks
    private static UserDeleteController userDeleteController;

    @Mock
    private static UserRemover userRemover;

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
    void return_call_user_remover() {
        ResponseEntity<Void> response = userDeleteController.index(UsersMother.searchAll().get(0).id());
        verify(userRemover).remove(anyString());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}