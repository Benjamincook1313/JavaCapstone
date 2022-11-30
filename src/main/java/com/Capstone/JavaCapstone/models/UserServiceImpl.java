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

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepo userRepo;
  @Autowired
  PasswordEncoder encoder;

  // add password validation (minChars, specialChar, hasNum)
  // add password reset
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
      }else{
        resp.add("Incorrect password");
      }
    }else{
      resp.add("Invalid Email");
    }
    return resp;
  }

  // get user account data
  // secure account data to only be accessed when logged in
  @Override
  @Transactional
  public Optional<UserDto> userInfo(Long userId){
    Optional<User> userData = userRepo.findById(userId);
    userData.ifPresent(user -> user.setPassword(""));
    return userData.map(UserDto::new);
  }

  // update account
  @Override
  @Transactional
  public void updateUser(Long userId, UserDto userDto){
    Optional<User> userOptional = userRepo.findById(userId);
    userOptional.ifPresent(user -> {
      user.setEmail(userDto.getEmail());
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setPassword(userOptional.get().getPassword());
      userRepo.saveAndFlush(user);
    });
  }

  // delete account
  @Override
  @Transactional
  public void deleteUser(Long userId){
    Optional<User> userOptional = userRepo.findById(userId);
    userOptional.ifPresent(user -> userRepo.deleteById(user.getId()));
  }

}
