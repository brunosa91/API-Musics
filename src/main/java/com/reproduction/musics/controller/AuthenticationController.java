package com.reproduction.musics.controller;

import com.reproduction.musics.dto.AuthenticationDto;
import com.reproduction.musics.dto.RegisterDto;
import com.reproduction.musics.model.User;
import com.reproduction.musics.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto authDto){
        var userNamePassword = new UsernamePasswordAuthenticationToken(authDto.getLogin(),authDto.getPassword());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto registerDto){

        if(userRepository.findByLogin(registerDto.getLogin()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encriptedPassword = new BCryptPasswordEncoder().encode(registerDto.getPassword());
        User newUser = new User(registerDto.getLogin(),encriptedPassword,registerDto.getUserRole());
        userRepository.save(newUser);
        return ResponseEntity.ok().build();

    }


}
