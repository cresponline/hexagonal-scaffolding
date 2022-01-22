package com.screspo.hexagonal.users.domain;

import java.util.List;

public interface UsersRepository {

    List<User> searchAll();

    void save(User user);
}
