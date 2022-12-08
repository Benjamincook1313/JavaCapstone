package com.Capstone.JavaCapstone.entities.listTypes;

import com.Capstone.JavaCapstone.enums.UnitTypes;
import com.Capstone.JavaCapstone.enums.CookType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RecipeLi {

  private CookType type;
  private double time;
  private UnitTypes timeUnit;
  private int temp;

}
