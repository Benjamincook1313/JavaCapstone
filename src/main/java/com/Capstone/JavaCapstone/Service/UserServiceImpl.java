package com.Capstone.JavaCapstone.Service;

import com.Capstone.JavaCapstone.dtos.UserDto;
import com.Capstone.JavaCapstone.entity.User;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {
  @Autowired
  private UserRepo userRepo;
  @Autowired
  PasswordEncoder encoder;

  public UserServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  // register user
  @Transactional
  public List<String> addUser(UserDto userDto){
    List<String> resp = new ArrayList<>();
    User user = new User(userDto);
    // adds encrypted password to the new user object
    user.setPassword(encoder.encode(userDto.getPassword()));
    if(userRepo.findUserByEmail(userDto.getEmail()) != null){
      resp.add("User already exists");
    }else{
      userRepo.saveAndFlush(user);
      resp.add("User Creation Succesful");
    }
;   return resp;
  }

}
