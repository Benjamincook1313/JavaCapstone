package com.Capstone.JavaCapstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "groups")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique=true)
  private String name;
  @JsonBackReference
  @OneToOne(cascade=CascadeType.ALL)
  private User admin1;

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="admin2")
  private User admin2;

  @ManyToMany(cascade=CascadeType.ALL)
  @JoinTable(
      name="group_members",
      joinColumns=@JoinColumn(name="group_id"),
      inverseJoinColumns=@JoinColumn(name="member_id")
  )
  private Collection<User> members;

  public Group(String name, User admin1) {
    this.name = name;
    this.admin1 = admin1;
  }

}
