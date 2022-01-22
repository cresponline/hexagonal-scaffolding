package com.screspo.hexagonal.users.application.dtos;

import com.screspo.hexagonal.users.domain.User;

public class UserDTO {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;

    public UserDTO(String id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public static UserDTO fromAggregate(User user) {
        return new UserDTO(user.id(), user.name(), user.surname(), user.email());
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }



}
