package com.codecraft.bwtt03.service;

import com.codecraft.bwtt03.dto.UserDto;
import com.codecraft.bwtt03.request.SignUpRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto registerUser(SignUpRequest signUpRequest);
    UserDto getUserBYId(UUID id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UUID id, UserDto userDetails);

    void deleteUser (UUID id);
}
