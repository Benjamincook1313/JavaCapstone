package com.Capstone.JavaCapstone.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
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
  @Column(nullable = false)
  @Email
  private String email;

//  @Size(min=8)
//  @NotContainWhitespace
//  @ContainSpecial
//  @ContainDigit
  @Column(name="passHash", nullable = false)
  private String password;

//  @ManyToMany(mappedBy="users", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//  private Collection<Group> group;

//  @OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//  @JsonManagedReference
//  private List<Lists> list;

}
