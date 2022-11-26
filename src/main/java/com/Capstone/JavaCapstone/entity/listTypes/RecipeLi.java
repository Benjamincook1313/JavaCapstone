package com.Capstone.JavaCapstone.entity.listTypes;

import com.Capstone.JavaCapstone.entity.itemTypes.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RecipeLi {

  private CookType type;
  private double time;
  private Unit timeUnit;
  private int temp;

}
