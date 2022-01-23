package com.screspo.hexagonal.users.infraestructure.persistence;

import com.screspo.hexagonal.users.domain.User;
import com.screspo.hexagonal.users.domain.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryUsersRepository implements UsersRepository {

    List<User> users;

    public InMemoryUsersRepository() {
        this.users = init();
    }


    @Override
    public List<User> searchAll() {
        return this.users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void delete(String id) {
        users = users.stream()
                .filter(user -> !user.id().equalsIgnoreCase(id))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> search(String id) {
        return users.stream()
                .filter(user -> user.id().equalsIgnoreCase(id))
                .findFirst();
    }

    private List<User> init() {
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
