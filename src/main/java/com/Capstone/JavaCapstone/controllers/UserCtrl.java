package com.Capstone.JavaCapstone.controllers;

import com.Capstone.JavaCapstone.services.UserService;
import com.Capstone.JavaCapstone.dtos.UserDto;
import com.Capstone.JavaCapstone.entities.User;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserCtrl {
  @Autowired
  private UserRepo repo;
  @Autowired
  private UserService userService;
  @Autowired
  private PasswordEncoder encoder;

  public UserCtrl() {
  }

  @PostMapping("/register")
  public List<String> addUser(@RequestBody UserDto userDto){
    String passHash = encoder.encode(userDto.getPassword());
    userDto.setPassword(passHash);
    return userService.addUser(userDto);
  }

  @PostMapping("/login")
  public List<String> login(@RequestBody UserDto userDto){
    return userService.login(userDto);
  }

  @GetMapping("/account/{userId}")
  public Optional<User> userInfo(@PathVariable Long userId){
    Optional<User> data = repo.findById(userId);
    data.ifPresent(user -> user.setPassword(""));
    return data;
  }

  @PutMapping("/account/{userId}")
  public void updateAccount(@PathVariable Long userId, @RequestBody UserDto userDto) {
    userService.updateUser(userId, userDto);
  }

  @DeleteMapping("/account/{userId}")
  public void deleteAccount(@PathVariable Long userId){
    userService.deleteUser(userId);
  }
}
