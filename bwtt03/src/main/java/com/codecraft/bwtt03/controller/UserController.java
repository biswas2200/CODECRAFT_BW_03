package com.codecraft.bwtt03.controller;

import com.codecraft.bwtt03.dto.UserDto;
import com.codecraft.bwtt03.exception.BadRequestException;
import com.codecraft.bwtt03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        UserDto user = userService.getUserBYId(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);//200
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id,
                                                     @RequestBody UserDto dto) {
        if (dto.getEmail() == null || !dto.getEmail().contains("@"))
            throw new BadRequestException("Invalid email address");
        if (dto.getAge() > 90)
            throw new BadRequestException("Age above 90 years");
        UserDto updatedUser = userService.updateUser(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//204
    }
}
