package com.screspo.hexagonal.users.infraestructure.controllers.users;

import com.screspo.hexagonal.users.application.dtos.UsersDTO;
import com.screspo.hexagonal.users.application.use_cases.all_users.AllUsersSearcher;
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
    void call_all_users_searcher() {
        usersGetController.index();
        verify(allUsersSearcher).search();
    }

    @Test
    void response_with_http_status_ok() {
        ResponseEntity<UsersDTO> usersResponse = usersGetController.index();
        assertEquals(HttpStatus.OK, usersResponse.getStatusCode());
    }

}