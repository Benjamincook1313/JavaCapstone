package com.Capstone.JavaCapstone.entities.itemTypes;

import com.Capstone.JavaCapstone.entities.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recipe extends Item {
  private UnitTypes unit;

  public Recipe(String item, Boolean crossedOff, String description, Lists list, UnitTypes unit) {
    super(item, crossedOff, description, list);
    this.unit = unit;
  }
}
