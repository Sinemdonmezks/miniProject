package com.example.ksdproject.controller;

import com.example.ksdproject.dto.LoginDto;
import com.example.ksdproject.dto.UserRequest;
import com.example.ksdproject.dto.UserResponse;
import com.example.ksdproject.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
//@SecurityRequirement(name = "Authorization")
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse saveUser(UserRequest user) {
       return userService.saveUser(user);
    }

    @GetMapping
    public List<UserResponse> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginUser(LoginDto user) {
        return ResponseEntity.ok(userService.loginUser(user));
    }
}
