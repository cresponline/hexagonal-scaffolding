package com.screspo.hexagonal.users.application.use_cases.update_user;

import com.screspo.hexagonal.users.application.exceptions.UserNotFoundException;
import com.screspo.hexagonal.users.application.use_cases.all_users.AllUsersSearcher;
import com.screspo.hexagonal.users.domain.User;
import com.screspo.hexagonal.users.domain.UsersRepository;
import com.screspo.hexagonal.users.mothers.UserDTOMother;
import com.screspo.hexagonal.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserEditorShould {

    @InjectMocks
    private static UserEditor userEditor;

    @Mock
    private static UsersRepository usersRepository;

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
    void throw_user_not_found_exception() {
        when(usersRepository.search(anyString())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,
                () -> userEditor.edit(UserDTOMother.random()));
    }
}