package com.authjwt.backend.controller;

import com.authjwt.backend.dto.CredentialsDto;
import com.authjwt.backend.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/login")

    public ResponseEntity<UserDto>  login(@RequestBody CredentialsDto credentialsDto ){
        UserDto user = userService.login(CredentialsDto);
        return ResponseEntity.ok(user);

    }
}
