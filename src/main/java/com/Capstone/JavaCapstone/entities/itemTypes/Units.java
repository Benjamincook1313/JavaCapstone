package com.Capstone.JavaCapstone.entities.itemTypes;

public enum Units {
  // Units
  ITEM("ITEM"),
  Can("CAN"),
  BOX("BOX"),
  BTL("BOTTLE"),
  CASE("CASE"),
  // Weight
  LB("LB"),
  OZ("OZ"),
  G("G"),
  // Vol
  GAL("Gal"),
  LTR("LTR"),
  QT("QT"),
  PT("PT"),
  //Size
  XS("XS"),
  S("S"),
  M("M"),
  L("L"),
  XL("XL"),
  XXL("XXL"),
  // Dist / Length
  MI("MI"),
  IN("IN"),
  FT("FT"),
  YD("YD"),
  // TIME
  MIN("MIN"),
  SEC("SEC"),
  HR("HR"),
  DAY("DAY"),
  WK("WK"),
  MTH("MTH"),
  YR("YR");

  private String unit;

  Units(String unit) {
    unit = unit;
  }
}
