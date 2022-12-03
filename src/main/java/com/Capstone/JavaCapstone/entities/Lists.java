package com.Capstone.JavaCapstone.entities;

import com.Capstone.JavaCapstone.dtos.ListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lists {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String title;

  @Column(columnDefinition="varchar default 'ITEM'", nullable = false)
  private ListTypes type;
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name="owner_id", nullable = false)
  private User owner;

  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="group_id")
  private Group group;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="list_items")
  private Set<Item> items;

  public Lists(String title, User owner) {
    this.title = title;
    this.owner = owner;
  }

  public Lists(ListDto listDto) {
    if(listDto.getId() != null) this.id = listDto.getId();
    if(listDto.getTitle() != null) this.title = listDto.getTitle();
    if(listDto.getType() != null) this.type = listDto.getType();
    if(listDto.getGroup() != null) this.group = listDto.getGroup();
    if(listDto.getOwner() != null) this.owner = listDto.getOwner();
  }
}
