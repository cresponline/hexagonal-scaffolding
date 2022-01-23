package com.screspo.hexagonal.users.application.use_cases.update_user;

import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.application.exceptions.UserNotFoundException;
import com.screspo.hexagonal.users.domain.User;
import com.screspo.hexagonal.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEditor {

    private final UsersRepository usersRepository;

    public UserEditor(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public void edit(UserDTO userDTO) {
        usersRepository.search(userDTO.id())
                .map(user -> userFromDto(userDTO))
                .ifPresentOrElse(usersRepository::save,
                        () -> {
                            throw new UserNotFoundException();
                        });
    }

    private User userFromDto(UserDTO userDTO) {
        return new User.Builder()
                .id(userDTO.id())
                .name(userDTO.name())
                .surname(userDTO.surname())
                .email(userDTO.email())
                .build();
    }
}
