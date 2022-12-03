package com.Capstone.JavaCapstone.entities.listTypes;

import com.Capstone.JavaCapstone.entities.itemTypes.Units;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RecipeLi {

  private CookType type;
  private double time;
  private Units timeUnit;
  private int temp;

}
