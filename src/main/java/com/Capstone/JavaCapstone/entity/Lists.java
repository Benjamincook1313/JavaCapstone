package com.Capstone.JavaCapstone.entity;

import com.Capstone.JavaCapstone.entity.listTypes.ListType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  @Column(columnDefinition = "varchar default 'ITEM'")
  private ListType type;
  @ManyToOne
  @JoinColumn(name="owner", nullable = false)
//  @JsonBackReference
  private User user;

//  @ManyToOne
//  @JoinColumn(name="group_id")
//  private Groups group;

//  @OneToMany(mappedBy="lists", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//  @JsonManagedReference
//  private List<Items> items;

  public Lists(String title, User user) {
    this.title = title;
    this.user = user;
  }
}
