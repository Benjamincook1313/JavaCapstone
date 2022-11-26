package com.Capstone.JavaCapstone.entity;

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
public class Group {
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique=true)
  private String groupName;
  @OneToOne(cascade=CascadeType.ALL)
//  @JoinColumn(name="admin1")
  @JsonBackReference
  private User admin1;

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="admin2")
//  @JsonBackReference
  private User admin2;

  @ManyToMany(cascade=CascadeType.ALL)
  @JoinTable(
      name="group_members",
      joinColumns=@JoinColumn(name="group_id"),
      inverseJoinColumns=@JoinColumn(name="member")
  )
  private Collection<User> member;

  public Group(String groupName, User admin1) {
    this.groupName = groupName;
    this.admin1 = admin1;
  }

}
