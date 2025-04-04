package com.unicesumar.entities;

import java.util.UUID;

public class User extends Entity {
    private final String name;
    private final String email;
    private final String password;

    public User(UUID uuid, String name, String email, String password) {
        super(uuid);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        super(UUID.randomUUID());
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + getUuid() +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}