package com.Capstone.JavaCapstone.entity.itemTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shop extends Item {
  private Unit unit;
  @Column(columnDefinition = "double default 0.00")
  private double price;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Shop shopItem = (Shop) o;
    return Double.compare(shopItem.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.getId(), super.getItem(), price, super.getQty(),
        unit, super.getCrossedOff(), super.getDescription());
  }

  @Override
  public String toString() {
    return "Shop{" +
        "id=" + super.getId() +
        ", item='" + super.getItem() + '\'' +
        ", price=" + price +
        ", qty=" + super.getQty() +
        ", units='" + unit + '\'' +
        ", crossedOff=" + super.getCrossedOff() +
        ", description='" + super.getDescription() + '\'' +
        ", list=" + super.getList() +
        '}';
  }
}
