package com.Capstone.JavaCapstone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lists {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  @ManyToOne
  @JoinColumn(name="owner")
//  @JsonBackReference
  private Users user;

  @ManyToOne
  @JoinColumn(name="group_id")
  private Groups group;

//  @OneToMany(mappedBy="lists", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//  @JsonManagedReference
//  private List<Items> items;

  public Lists(String title, Users user) {
    this.title = title;
    this.user = user;
  }
}
