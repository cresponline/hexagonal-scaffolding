package com.screspo.hexagonal.users.application.use_cases.find_user;

import com.screspo.hexagonal.users.application.exceptions.UserNotFoundException;
import com.screspo.hexagonal.users.domain.User;
import com.screspo.hexagonal.users.domain.UsersRepository;
import com.screspo.hexagonal.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserSearcherShould {

    @InjectMocks
    private static UserSearcher userSearcher;

    @Mock
    private static UsersRepository usersRepository;
    private final User user = UsersMother.searchAll().get(0);
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
    void throw_an_user_not_found_exception() {
        when(usersRepository.search(anyString())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,
                () -> userSearcher.search("random-id"));
        verify(usersRepository).search(anyString());
    }

}