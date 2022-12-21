package com.Capstone.JavaCapstone.controllers;

import com.Capstone.JavaCapstone.services.UserService;
import com.Capstone.JavaCapstone.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserCtrl {
  @Autowired
  private UserService userService;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public List<String> addUser(@RequestBody UserDto userDto){
    String hashPass = passwordEncoder.encode(userDto.getPassword());
    userDto.setPassword(hashPass);
    if(hashPass != null) return userService.addUser(userDto);
    return null;
  }

  @PostMapping("/login")
  public List<String> login(@RequestBody UserDto userDto){
    return userService.login(userDto);
  }

  // TODO: check if user is logged in
  // TODO: logout user

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
