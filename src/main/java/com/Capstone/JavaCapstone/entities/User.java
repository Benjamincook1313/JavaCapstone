package com.Capstone.JavaCapstone.entities;

import com.Capstone.JavaCapstone.dtos.UserDto;
import com.github.ankurpathak.password.bean.constraints.ContainDigit;
import com.github.ankurpathak.password.bean.constraints.ContainSpecial;
import com.github.ankurpathak.password.bean.constraints.NotContainWhitespace;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Email
  @Column(nullable = false, unique = true)
  private String email;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="lists")
  private Collection<Lists> lists;

  @OneToMany(cascade = CascadeType.DETACH)
  @JoinColumn(name="groups")
  private Collection<Group> groups;

  @Size(min=7)
  @NotContainWhitespace
  @ContainSpecial
  @ContainDigit
  @Column(name="passHash", nullable = false)
  private String password;


  public User(String firstName, String lastName, String email, String password, Collection<Lists> lists) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.lists = lists;
  }

  public User(UserDto userDto) {
    if(userDto.getFirstName() != null) this.firstName = userDto.getFirstName();
    if(userDto.getLastName() != null) this.lastName = userDto.getLastName();
    if(userDto.getEmail() != null) this.email = userDto.getEmail();
    if(userDto.getPassword() != null) this.password = userDto.getPassword();
    if(userDto.getLists() != null) this.lists = userDto.getLists();
  }
}
