package com.Capstone.JavaCapstone.models;

import com.Capstone.JavaCapstone.services.UserService;
import com.Capstone.JavaCapstone.dtos.UserDto;
import com.Capstone.JavaCapstone.entities.User;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {
  @Autowired
  UserRepo userRepo;
  @Autowired
  PasswordEncoder encoder;

  // todo: add password validation (minChars, specialChar, hasNum)
  // todo: add password reset

  @Override
  @Transactional
  public List<String> addUser(UserDto userDto){
    List<String> resp = new ArrayList<>();
    User user = new User(userDto);
    if(userRepo.findUserByEmail(userDto.getEmail()).isPresent()){
      resp.add("User already exists");
    }else{
      userRepo.saveAndFlush(user);
      resp.add("Success, User Registered!");
    }

    return resp;
  }

  @Override
  @Transactional
  public List<String> login(UserDto userDto){
    List<String> resp = new ArrayList<>();
    Optional<User> userOptional = userRepo.findUserByEmail(userDto.getEmail());

    if(userOptional.isPresent()){
      if(encoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
        resp.add("Login Successful!");
        resp.add(String.valueOf(userOptional.get().getId()));
      }else resp.add("Incorrect password");
    }else resp.add("Invalid Email");

    return resp;
  }

  // get user account data
  @Override
  @Transactional
  public List<UserDto> getUserInfo(Long userId){
    Optional<User> userOptional = userRepo.findById(userId);
    userOptional.ifPresent(user -> user.setPassword(""));
    return userOptional.stream().map(UserDto::new).collect(Collectors.toList());
  }

  // todo: update password

  // update account
  @Override
  @Transactional
  public List<String> updateUser(Long userId, UserDto userDto){
    List<String> resp = new ArrayList<>();
    Optional<User> userOptional = userRepo.findById(userId);
    userOptional.ifPresent(user -> {
      if (userDto.getEmail() != null) user.setEmail(userDto.getEmail());
      else user.setEmail(user.getEmail());

      if (userDto.getFirstName() != null) user.setFirstName(userDto.getFirstName());
      else user.setFirstName(user.getFirstName());

      if(userDto.getLastName() != null) user.setLastName(userDto.getLastName());
      else user.setLastName(user.getLastName());

      user.setPassword(user.getPassword());
      resp.add("Success, account info updated!");

      userRepo.saveAndFlush(user);
    });

    return resp;
  }


  // delete account
  @Override
  @Transactional
  public List<String> deleteUser(Long userId){
    List<String> resp = new ArrayList<>();
    userRepo.deleteById(userId);
    resp.add("Success, User data deleted!");
    return resp;
  }
}
