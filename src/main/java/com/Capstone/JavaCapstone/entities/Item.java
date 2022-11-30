package com.Capstone.JavaCapstone.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

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
  @Column(columnDefinition="boolean default false")
  private Boolean crossedOff;
  private String description;
  @JsonIgnore
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
