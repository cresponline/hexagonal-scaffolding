package com.screspo.hexagonal.users.application.use_cases.delete;

import com.screspo.hexagonal.users.domain.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

class UserRemoverTest {

    @InjectMocks
    private static UserRemover userRemover;

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
    void shouldCallUserRepositoryDelete() {
        userRemover.remove("id");
        verify(usersRepository).delete(anyString());
    }

}