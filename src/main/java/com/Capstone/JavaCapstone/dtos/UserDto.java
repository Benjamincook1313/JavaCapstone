package com.Capstone.JavaCapstone.dtos;

import com.Capstone.JavaCapstone.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  public UserDto(User user){
    if(user.getId() != null) this.id = user.getId();
    if(user.getFirstName() != null) this.firstName = user.getFirstName();
    if(user.getLastName() != null) this.lastName = user.getLastName();
    if(user.getEmail() != null) this.email = user.getEmail();
    if(user.getPassword() != null) this.password = user.getPassword();
  }

}
