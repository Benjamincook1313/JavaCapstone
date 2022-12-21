package com.Capstone.JavaCapstone.enums;

public enum UnitTypes {
  // Units
  UNIT("UNIT"),
  CAN("CAN"),
  BOX("BOX"),
  BTL("BOTTLE"),
  CASE("CASE"),
  PAIR("PAIR"),
  PKG("PKG"),
  BAG("BAG"),
  BSHL("BSHL"),
  PEC("PEC"),
  BCH("BCH"),
  BKT("BKT"),

  // Weight
  LB("LB"),
  OZ("OZ"),
  GM("GM"),

  // Volume
  GAL("Gal"),
  LTR("LTR"),
  QT("QT"),
  PT("PT"),
  CP("CP"),
  TBLS("TBLS"),
  TSP("TSP"),

  //Sizes
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

  UnitTypes(String unit) {
    unit = unit;
  }
}
