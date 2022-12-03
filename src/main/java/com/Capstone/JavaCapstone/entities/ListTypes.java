package com.Capstone.JavaCapstone.entities;

public enum ListTypes {
  ITEM("ITEM"),
  SHOP("SHOP"),
  TASK("TASK"),
  RECIPE("RECIPE"),
  TRAVEL("TRAVEL");

  public final String label;

  ListTypes(String label) {
    this.label = label;
  }

}
