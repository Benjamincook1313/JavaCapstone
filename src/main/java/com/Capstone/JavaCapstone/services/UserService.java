package com.Capstone.JavaCapstone.services;

import com.Capstone.JavaCapstone.dtos.UserDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserService {
  // add password validation (minChars, specialChar, hasNum)
  // add password reset
  @Transactional
  List<String> addUser(UserDto userDto);

  @Transactional
  List<String> login(UserDto userDto);

  // get user account data
  // secure account data to only be accessed when logged in
  @Transactional
  Optional<UserDto> userInfo(Long userId);

  // update account
  @Transactional
  void updateUser(Long userId, UserDto userDto);

  // delete account
  @Transactional
  void deleteUser(Long userId);
}
