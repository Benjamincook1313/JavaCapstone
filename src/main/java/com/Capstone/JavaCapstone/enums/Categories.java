package com.Capstone.JavaCapstone.enums;

public enum Categories {

  NONE("NONE"),
  PRODUCE("PRODUCE"),
  BAKING("BAKING"),
  BAKERY("BAKERY"),
  CANNED("CANNED"),
  CONDIMENTS("CONDIMENTS"),
  FROZEN("FROZEN"),
  BREAKFAST("BREAKFAST"),
  DAIRY("DAIRY"),
  DELI("DELI"),
  SNACKS("SNACKS"),
  DRINKS("DRINKS"),
  HISPANIC("HISPANIC"),
  ASIAN("ASIAN"),
  AUTO("AUTO"),
  CLEANING("CLEANING"),
  KITCHEN("KITCHEN"),
  HEALTH("HEALTH"),
  BABY("BABY"),
  PET("PET"),
  BEAUTY("BEAUTY"),
  PHARMACY("PHARMACY"),
  SPORTS("SPORTS"),
  OUTDOORS("OUTDOORS"),
  PAINT("PAINT"),
  SEASONAL("SEASONAL"),
  OFFICE("OFFICE"),
  CLOTHES("CLOTHES"),
  SHOES("SHOES"),
  GARDEN("GARDEN"),
  TOOLS("TOOLS"),
  DIY("DIY"),
  MISC("MISC");

  private String category;

  Categories(String category) {
    this.category = category;
  }
}
