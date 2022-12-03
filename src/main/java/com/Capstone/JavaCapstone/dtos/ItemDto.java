package com.Capstone.JavaCapstone.dtos;

import com.Capstone.JavaCapstone.entities.Item;
import com.Capstone.JavaCapstone.entities.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

  private Long id;
  private String name;
  private Integer qty;
  private String units;
  private Boolean crossedOff;
  private String description;
  private Lists list;

  public ItemDto(Item item){
    if(item.getId() != null) this.id = item.getId();
    if(item.getName() != null) this.name = item.getName();
    if(item.getQty() != null) this.qty = item.getQty();
    if(item.getUnits() != null) this.units = item.getUnits();
    if(item.getCrossedOff() != null) this.crossedOff = item.getCrossedOff();
    if(item.getDescription() != null) this.description = item.getDescription();
    if(item.getList() != null) this.list = item.getList();
  }
}
