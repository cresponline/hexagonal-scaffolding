package com.screspo.hexagonal.users.application.all_users;

import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.dtos.UsersDTO;
import com.screspo.hexagonal.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AllUsersSearcher {

    private final UsersRepository userRepository;

    public AllUsersSearcher(UsersRepository usersRepository) {
        this.userRepository = usersRepository;
    }


    public UsersDTO search() {
        return new UsersDTO(userRepository.searchAll()
                .stream()
                .map(UserDTO::fromAggregate)
                .collect(Collectors.toList()));
    }
}
