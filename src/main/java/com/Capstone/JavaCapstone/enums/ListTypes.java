package com.Capstone.JavaCapstone.enums;

public enum ListTypes {
  ITEM("ITEM"),
  SHOP("SHOP"),
  TASK("TASK"),
  RECIPE("RECIPE"),
  TRAVEL("TRAVEL"),
  // Food Order
  // sharable web link
  // invite to download app when list is updated
  ORDER("ORDER");

  public final String label;

  ListTypes(String label) {
    this.label = label;
  }

}
