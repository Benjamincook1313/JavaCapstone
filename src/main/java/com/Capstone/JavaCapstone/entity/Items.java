package com.Capstone.JavaCapstone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Items {
  @Id
  @GeneratedValue
  private Long id;
  private String itemName;
  private Integer qty;
  private String qtyType;
  private Boolean crossedOff;
  private String description;
  @ManyToOne
  @JoinColumn(name="list_id")
  private Lists list;

  public Items(String itemName, Integer qty, String qtyType, Boolean crossedOff, String description, Lists list) {
    this.itemName = itemName;
    this.qty = qty;
    this.qtyType = qtyType;
    this.crossedOff = crossedOff;
    this.description = description;
    this.list = list;
  }
}
