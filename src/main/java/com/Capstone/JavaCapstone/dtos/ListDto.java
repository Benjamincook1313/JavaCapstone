package com.Capstone.JavaCapstone.dtos;

import com.Capstone.JavaCapstone.entities.Group;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.User;
import com.Capstone.JavaCapstone.entities.ListType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListDto implements Serializable {
  private Long id;
  private String title;
  private ListType type;

  private User owner;
  private Group group;

  public ListDto(Lists list) {
    if(list.getId() != null) this.id = list.getId();
    if(list.getTitle() != null) this.title = list.getTitle();
    if(list.getType() != null) this.type = list.getType();
    if(list.getGroup() != null) this.group = list.getGroup();
  }

}
