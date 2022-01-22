package com.screspo.hexagonal.users.application.dtos;

import com.screspo.hexagonal.users.domain.User;

public class UserResponse {
    private final String id;
    private final String email;

    public UserResponse(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(user.id(), user.email());
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }



}
