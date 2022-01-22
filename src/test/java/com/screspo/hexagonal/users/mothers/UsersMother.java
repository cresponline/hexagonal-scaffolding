package com.screspo.hexagonal.users.mothers;

import com.screspo.hexagonal.users.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UsersMother {
    public static List<User> searchAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User.Builder()
                .id("user1-id")
                .name("user1")
                .surname("one")
                .email("user_one@email.com")
                .build();

        users.add(user1);

        User user2 = new User.Builder()
                .id("user2-id")
                .name("user2")
                .surname("two")
                .email("user_two@email.com")
                .build();

        users.add(user2);

        return users;
    }
}
