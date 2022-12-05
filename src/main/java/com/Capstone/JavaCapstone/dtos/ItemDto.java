package com.Capstone.JavaCapstone.dtos;

import com.Capstone.JavaCapstone.entities.Item;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.itemTypes.UnitTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto implements Serializable {

  private Long id;
  private String name;
  private Integer qty;
  private UnitTypes unit;
  private Boolean crossedOff;
  private String description;
  private Lists list;

  public ItemDto(Item item){
    if(item.getId() != null) this.id = item.getId();
    if(item.getName() != null) this.name = item.getName();
    if(item.getQty() != null) this.qty = item.getQty();
    if(item.getUnit() != null) this.unit = item.getUnit();
    if(item.getCrossedOff() != null) this.crossedOff = item.getCrossedOff();
    if(item.getDescription() != null) this.description = item.getDescription();
    if(item.getList() != null) this.list = item.getList();
  }
}
