package com.screspo.hexagonal.users.mothers;

import com.screspo.hexagonal.users.application.dtos.UserDTO;
import com.screspo.hexagonal.users.domain.User;

public class UserDTOMother {
    public static UserDTO create(String id, String name, String surname, String email) {
        return new UserDTO(id, name, surname, email);
    }

    public static UserDTO random() {
        return create("UserDTOMother-id", "UserDTOMother-name", "UserDTOMother-surname", "UserDTOMother@email.com");
    }

    public static UserDTO createFromUser(User user) {
        return create(user.id(), user.name(), user.surname(), user.email());
    }
}
