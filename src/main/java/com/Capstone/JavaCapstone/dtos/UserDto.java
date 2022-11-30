package com.Capstone.JavaCapstone.dtos;

import com.Capstone.JavaCapstone.entities.User;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
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
