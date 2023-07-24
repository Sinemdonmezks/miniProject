package com.example.ksdproject.service;

import com.example.ksdproject.dto.LoginDto;
import com.example.ksdproject.dto.UserRequest;
import com.example.ksdproject.dto.UserResponse;
import com.example.ksdproject.entity.User;
import com.example.ksdproject.mapper.UserMapper;
import com.example.ksdproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse saveUser(UserRequest user) {
        User userEntity = userRepository.save(userMapper.toEntity(user));
        return userMapper.toDto(userEntity);
    }

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean loginUser(LoginDto user) {
        User userEntity = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.toDto(userEntity);
        return true;
    }

    public List<UserResponse> getAllUser() {
        return userMapper.toUserResponseList(userRepository.findAll());
    }
}
