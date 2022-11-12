package com.Capstone.JavaCapstone.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
  @Id
  @GeneratedValue
  @JsonManagedReference
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  @Column(name="passHash")
  private String password;

//  @ManyToMany(mappedBy="users", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//  private Collection<Groups> groups;

//  @OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//  @JsonManagedReference
//  private List<Lists> list;


  public Users(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }
}
