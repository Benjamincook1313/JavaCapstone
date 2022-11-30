package com.Capstone.JavaCapstone.entities;

public enum ListType {
  ITEM("ITEM"),
  SHOP("SHOP"),
  TASK("TASK"),
  RECIPE("RECIPE"),
  TRAVEL("TRAVEL");

  public final String label;

  ListType(String label) {
    this.label = label;
  }

}
