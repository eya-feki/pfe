package com.authjwt.backend.repositories;

import com.authjwt.backend.entities.User;

public interface UserRepository JpaRepository<User, Integer> {
    Optional<User> findBylogin(String login);
}
