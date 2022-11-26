package com.Capstone.JavaCapstone.entity.itemTypes;

import com.Capstone.JavaCapstone.entity.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
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
