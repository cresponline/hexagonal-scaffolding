package com.screspo.hexagonal.users.application.dtos;

import java.util.List;

public class UsersResponse {

    private final List<UserResponse> users;

    public UsersResponse(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

}
