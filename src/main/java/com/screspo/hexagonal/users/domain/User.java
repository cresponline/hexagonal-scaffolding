package com.screspo.hexagonal.users.domain;

public class User {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
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

    public static class Builder {
        private String id;
        private String name;
        private String surname;
        private String email;

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }


}
