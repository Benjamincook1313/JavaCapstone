package com.Capstone.JavaCapstone.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lists {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String title;

//  @Column(columnDefinition="varchar default 'ITEM'")
  private ListType type;
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="owner_id")
  private User owner;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="group_id")
  private Group group;

  public Lists(String title, User user) {
    this.title = title;
    this.owner = user;
  }
}
