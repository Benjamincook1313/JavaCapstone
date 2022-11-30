package com.Capstone.JavaCapstone.entities.itemTypes;

import com.Capstone.JavaCapstone.entities.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
  @Id
  @GeneratedValue
  private Long id;
  private String item;
  @Column(columnDefinition = "integer default 1")
  private double qty;
  @Column(columnDefinition = "boolean default false")
  private Boolean crossedOff;
  private String description;
  private Lists list;

  private void toggle(){
    crossedOff = !crossedOff;
  }

  public Item(String item, Boolean crossedOff, String description, Lists list) {
    this.item = item;
    this.crossedOff = crossedOff;
    this.description = description;
    this.list = list;
  }

}