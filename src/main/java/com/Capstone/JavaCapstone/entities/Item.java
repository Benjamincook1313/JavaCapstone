package com.Capstone.JavaCapstone.entities;

import com.Capstone.JavaCapstone.dtos.ItemDto;
import com.Capstone.JavaCapstone.entities.itemTypes.UnitTypes;
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
  @Column(columnDefinition="integer default 1")
  private Integer qty;
  @Column(columnDefinition = "varchar default 'UNIT'", nullable = false)
  private UnitTypes unit;
  @Column(columnDefinition="boolean default false", nullable = false)
  private Boolean crossedOff;
  private String description;
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name="list_id", nullable = false)
  private Lists list;

  public Item(String name, Integer qty, UnitTypes unit, Boolean crossedOff, String description, Lists list) {
    this.name = name;
    this.qty = qty;
    this.unit = unit;
    this.crossedOff = crossedOff;
    this.description = description;
    this.list = list;
  }

  public Item(ItemDto itemDto){
    if(itemDto.getId() != null) this.id = itemDto.getId();
    if(itemDto.getName() != null) this.name = itemDto.getName();
    if(itemDto.getQty() != null) this.qty = itemDto.getQty();
    if(itemDto.getUnit() != null) this.unit = itemDto.getUnit();
    if(itemDto.getCrossedOff() != null) this.crossedOff = itemDto.getCrossedOff();
    if(itemDto.getDescription() != null) this.description = itemDto.getDescription();
    if(itemDto.getList() != null) this.list = itemDto.getList();
  }
}
