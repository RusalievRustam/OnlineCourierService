package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.UserDTO;
import org.example.repositories.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserDTO> UserList() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return userDTO;
    }

    @DeleteMapping("/user")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/user")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO, id);
    }
}
