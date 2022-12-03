package com.Capstone.JavaCapstone.services;

import com.Capstone.JavaCapstone.dtos.UserDto;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
  // todo: add password validation (minChars, specialChar, hasNum)
  // todo: add password reset
  @Transactional
  List<String> addUser(UserDto userDto);

  @Transactional
  List<String> login(UserDto userDto);

  // get user account data
  // todo: secure account data to only be accessed when logged in
  @Transactional
  List<UserDto> getUserInfo(Long userId);

  // update account
  @Transactional
  List<String> updateUser(Long userId, UserDto userDto);

  // delete account
  @Transactional
  List<String> deleteUser(Long userId);
}
