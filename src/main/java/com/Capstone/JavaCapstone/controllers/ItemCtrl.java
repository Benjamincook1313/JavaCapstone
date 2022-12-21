package com.Capstone.JavaCapstone.controllers;

import com.Capstone.JavaCapstone.dtos.ItemDto;
import com.Capstone.JavaCapstone.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user/{userId}/list/{listId}")
public class ItemCtrl {
  @Autowired
  ItemService itemService;
  // addItem
  @PostMapping("/item")
  public List<String> addItem(@PathVariable Long listId, @RequestBody ItemDto itemDto){
    return itemService.addListItem(listId, itemDto);
  }

  // get all items
  @GetMapping("/items")
  public List<ItemDto> getListItems(@PathVariable Long listId){
    return itemService.getListItems(listId);
  }

  // updateItem
  @PutMapping("/item/{itemId}")
  public List<String> updateIt(@PathVariable Long itemId, @RequestBody ItemDto itemDto){
    return itemService.updateItem(itemId, itemDto);
  }

  // cross/uncross item
  @PatchMapping("/item/{itemId}")
  public List<String> crossOff(@PathVariable Long itemId){
    return itemService.toggleCrossedOff(itemId);
  }

  // delete item
  @DeleteMapping("/item/{itemId}")
  public List<String> deleteIt(@PathVariable Long itemId, @PathVariable Long listId){
    return itemService.deleteItem(itemId, listId);
  }
}
