package com.Capstone.JavaCapstone.entities.itemTypes;

import com.Capstone.JavaCapstone.entities.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task extends Item{
  private Date dueDate;

  public Task(String item, Boolean crossedOff, String description, Lists list, Date dueDate) {
    super(item, crossedOff, description, list);
    this.dueDate = dueDate;
  }
}
