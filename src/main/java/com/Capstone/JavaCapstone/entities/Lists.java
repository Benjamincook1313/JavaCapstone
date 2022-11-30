package com.Capstone.JavaCapstone.entities;

import com.Capstone.JavaCapstone.dtos.ListDto;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String title;

  @Column(columnDefinition="varchar default 'ITEM'", nullable = false)
  private ListType type;
  @ManyToOne
  @JoinColumn(name="owner_id", nullable = false)
  private User owner;

  @ManyToOne
  @JoinColumn(name="group_id")
  private Group group;

  public Lists(String title, User user) {
    this.title = title;
    this.owner = user;
  }

  public Lists(ListDto listDto) {
    if(listDto.getId() != null) this.id = listDto.getId();
    if(listDto.getTitle() != null) this.title = listDto.getTitle();
    if(listDto.getType() != null) this.type = listDto.getType();
    if(listDto.getGroup() != null) this.group = listDto.getGroup();
  }
}
