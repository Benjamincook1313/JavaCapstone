package com.Capstone.JavaCapstone.services;

import com.Capstone.JavaCapstone.dtos.ItemDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface ItemService {
  // add item
  @Transactional
  List<String> addListItem(Long listId, ItemDto itemDto);

  // get list items
  @Transactional
  List<ItemDto> getListItems(Long listId);

  // update list item
  @Transactional
  List<String> updateItem(Long itemId, ItemDto itemDto);

  // crossOff/Uncross list item
  @Transactional
  List<String> toggleCrossedOff(Long itemId);

  // delete item
  @Transactional
  List<String> deleteItem(Long itemId);
}
