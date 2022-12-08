package com.Capstone.JavaCapstone.dtos;

import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.User;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;

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
  private Collection<Lists> lists;

  public UserDto(User user){
    if(user.getId() != null) this.id = user.getId();
    if(user.getFirstName() != null) this.firstName = user.getFirstName();
    if(user.getLastName() != null) this.lastName = user.getLastName();
    if(user.getEmail() != null) this.email = user.getEmail();
    if(user.getPassword() != null) this.password = user.getPassword();
    if(user.getLists() != null) this.lists = user.getLists();
  }

}
