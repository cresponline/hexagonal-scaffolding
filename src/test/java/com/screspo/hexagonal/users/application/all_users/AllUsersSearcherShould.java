package com.screspo.hexagonal.users.application.all_users;

import com.screspo.hexagonal.users.domain.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class AllUsersSearcherShould {

    @InjectMocks
    private static AllUsersSearcher allUsersSearcher;

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
    void search_should_call_UserRepository_searchAll() {
        allUsersSearcher.search();
        verify(usersRepository).searchAll();
    }
}