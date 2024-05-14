package com.reproduction.musics.repository;

import com.reproduction.musics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,String> {
    UserDetails findByLogin(String login);
}
