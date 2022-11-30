package com.Capstone.JavaCapstone.entities;

import com.Capstone.JavaCapstone.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.ankurpathak.password.bean.constraints.ContainDigit;
import com.github.ankurpathak.password.bean.constraints.ContainSpecial;
import com.github.ankurpathak.password.bean.constraints.NotContainWhitespace;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
  @Id
  @GeneratedValue
  @JsonManagedReference
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;

  @Email
  @Column(nullable = false, unique = true)
  private String email;

//  @Size(min=8)
  @NotContainWhitespace
  @ContainSpecial
  @ContainDigit
  @Column(name="passHash", nullable = false)
  private String password;

//  @ManyToMany(mappedBy="users", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//  private Collection<Group> group;

//  @OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//  @JsonManagedReference
//  private List<Lists> list;


  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public User(UserDto userDto) {
    if(userDto.getFirstName() != null) this.firstName = userDto.getFirstName();
    if(userDto.getLastName() != null) this.lastName = userDto.getLastName();
    if(userDto.getEmail() != null) this.email = userDto.getEmail();
    if(userDto.getPassword() != null) this.password = userDto.getPassword();
  }
}
