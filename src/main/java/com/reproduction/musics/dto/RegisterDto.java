package com.reproduction.musics.dto;

import com.reproduction.musics.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RegisterDto {
    private String login;
    private String password;
    private UserRole userRole;
}
