package com.Capstone.JavaCapstone.entities;

import com.Capstone.JavaCapstone.dtos.ItemDto;
import com.Capstone.JavaCapstone.enums.Categories;
import com.Capstone.JavaCapstone.enums.UnitTypes;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  private Integer qty;
  @Column(nullable = false)
  private UnitTypes unit;
  @Column(nullable = false)
  private Boolean crossedOff;
  private String description;
  private Categories category;
  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="list_id", nullable = false)
  private Lists list;

  public Item(String name, Integer qty, UnitTypes unit, Boolean crossedOff, Categories category, String description) {
    this.name = name;
    this.qty = qty;
    this.unit = unit;
    this.crossedOff = crossedOff;
    this.category = category;
    this.description = description;
  }

  public Item(ItemDto itemDto){
    if(itemDto.getId() != null) this.id = itemDto.getId();
    if(itemDto.getName() != null) this.name = itemDto.getName();
    if(itemDto.getQty() != null) this.qty = itemDto.getQty();
    if(itemDto.getUnit() != null) this.unit = itemDto.getUnit();
    if(itemDto.getCrossedOff() != null) this.crossedOff = itemDto.getCrossedOff();
    if(itemDto.getCategory() != null) this.category = itemDto.getCategory();
    if(itemDto.getDescription() != null) this.description = itemDto.getDescription();
    if(itemDto.getList() != null) this.list = itemDto.getList();
  }
}
