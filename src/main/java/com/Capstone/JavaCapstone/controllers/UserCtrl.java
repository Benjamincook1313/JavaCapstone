package com.Capstone.JavaCapstone.controllers;

import com.Capstone.JavaCapstone.services.UserService;
import com.Capstone.JavaCapstone.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserCtrl {
  @Autowired
  private UserService userService;
  @Autowired
  PasswordEncoder encoder;

  public UserCtrl() {
  }

  @PostMapping("/register")
  public List<String> addUser(@RequestBody UserDto userDto){
    String hashPass = encoder.encode(userDto.getPassword());
    userDto.setPassword(hashPass);
    return userService.addUser(userDto);
  }

  @PostMapping("/login")
  public List<String> login(@RequestBody UserDto userDto){

    return userService.login(userDto);
  }

  @GetMapping("/account/{userId}")
  public List<UserDto> getUserInfo(@PathVariable Long userId){
    return userService.getUserInfo(userId);
  }

  @PatchMapping("/account/{userId}")
  public List<String> updateAccount(@PathVariable Long userId, @RequestBody UserDto userDto) {
    return userService.updateUser(userId, userDto);
  }

  @DeleteMapping("/account/{userId}")
  public List<String> deleteAccount(@PathVariable Long userId){

    return userService.deleteUser(userId);
  }
}
