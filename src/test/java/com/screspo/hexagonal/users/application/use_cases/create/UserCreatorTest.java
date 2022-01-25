package com.screspo.hexagonal.users.application.use_cases.create;

import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.exceptions.UserAlreadyExistsException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserCreatorTest {

    @InjectMocks
    private static UserCreator userCreator;

    @Mock
    private static UsersRepository usersRepository;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        when(usersRepository.searchAll()).thenReturn(UsersMother.searchAll());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @Test
    void shouldCallUserRepositorySave() {
        userCreator.create(UserDTOMother.random());
        verify(usersRepository).save(any(User.class));
    }

    @Test
    void mustThrowAnUserAlreadyExistsException() {
        UserDTO existingUser = UserDTOMother.createFromUser(UsersMother.searchAll().get(0));
        assertThrows(UserAlreadyExistsException.class,
                () -> userCreator.create(existingUser));
    }


}