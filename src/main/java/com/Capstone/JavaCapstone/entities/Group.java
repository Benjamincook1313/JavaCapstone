package com.Capstone.JavaCapstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn
  private User admin1;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn
  private User admin2;

  @ManyToMany(cascade = CascadeType.DETACH)
  @JoinTable(
      name="group_members",
      joinColumns=@JoinColumn(name="group_id"),
      inverseJoinColumns=@JoinColumn(name="member_id")
  )
  private Set<User> members;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name="group_lists",
      joinColumns = @JoinColumn(name = "group_id"),
      inverseJoinColumns = @JoinColumn(name="list_id")
  )
  private Collection<Lists> lists;


  public Group(String name, User admin1) {
    this.name = name;
    this.admin1 = admin1;
  }

}
