package com.reproduction.musics.model;

import com.reproduction.musics.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login;
    private String password;
    private UserRole role;
}
