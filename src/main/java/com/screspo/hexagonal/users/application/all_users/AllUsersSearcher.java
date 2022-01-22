package com.screspo.hexagonal.users.application.all_users;

import com.screspo.hexagonal.users.application.dtos.UserResponse;
import com.screspo.hexagonal.users.application.dtos.UsersResponse;
import com.screspo.hexagonal.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AllUsersSearcher {

    private final UsersRepository userRepository;

    public AllUsersSearcher(UsersRepository usersRepository) {
        this.userRepository = usersRepository;
    }


    public UsersResponse search() {
        return new UsersResponse(userRepository.searchAll()
                .stream()
                .map(UserResponse::fromAggregate)
                .collect(Collectors.toList()));
    }
}
