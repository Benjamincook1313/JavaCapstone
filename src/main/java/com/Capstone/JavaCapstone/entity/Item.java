package com.Capstone.JavaCapstone.entity;

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
@Table(name="items")
public class Item {
  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String item;
  @Column(columnDefinition="integer default 1")
  private Integer qty;
  private String units;

//  @Column(columnDefinition = "float default 0.00")
//  private double price;
  @Column(columnDefinition="boolean default false")
  private Boolean crossedOff;
  private String description;

//  private Date dueDate;
  @ManyToOne
  @JoinColumn(name="list_id", nullable = false)
  private Lists list;

  public Item(String itemName, Integer qty, String units, Boolean crossedOff, String description, Lists list) {
    this.item = itemName;
    this.qty = qty;
    this.units = units;
    this.crossedOff = crossedOff;
    this.description = description;
    this.list = list;
  }
}
