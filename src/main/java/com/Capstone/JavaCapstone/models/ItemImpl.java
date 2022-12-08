package com.Capstone.JavaCapstone.models;

import com.Capstone.JavaCapstone.dtos.ItemDto;
import com.Capstone.JavaCapstone.entities.Item;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.enums.Categories;
import com.Capstone.JavaCapstone.enums.UnitTypes;
import com.Capstone.JavaCapstone.repositories.ItemRepo;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import com.Capstone.JavaCapstone.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemImpl implements ItemService {
  @Autowired
  private ItemRepo itemRepo;
  @Autowired
  private ListRepo listRepo;

  // add item
  @Override
  @Transactional
  public List<String> addListItem(Long listId, ItemDto itemDto) {
    List<String> resp = new ArrayList<>();
    Optional<Lists> listOptional = listRepo.findById(listId);
    Item item = new Item(itemDto);
    if (itemDto.getUnit() == null) item.setUnit(UnitTypes.valueOf("UNIT"));
    if(itemDto.getCategory() == null) item.setCategory(Categories.valueOf("NONE"));
    if(itemDto.getQty() == null) item.setQty(1);
    item.setCrossedOff(false);
    listOptional.ifPresent(list -> {
      item.setList(list);
      itemRepo.saveAndFlush(item);
      resp.add("Success, item added!");
    });

    return resp;
  }

  // get list items
  @Override
  @Transactional
  public List<ItemDto> getListItems(Long listId) {
    List<Item> itemList = itemRepo.findAllByListId(listId);
    List<ItemDto> itemDtoList = new ArrayList<>();
    if (itemList.isEmpty()) return null;
    for (Item item : itemList) {
      item.getList().getOwner().setLists(new ArrayList<>());
      itemDtoList.add(new ItemDto(item));
    }
    return itemDtoList;
  }

  // update list item
  @Override
  @Transactional
  public List<String> updateItem(Long itemId, ItemDto itemDto) {
    List<String> resp = new ArrayList<>();
    Optional<Item> itemOpt = itemRepo.findById(itemId);
    itemOpt.ifPresent(item -> {
      if(itemDto.getCrossedOff() != null) item.setCrossedOff(itemDto.getCrossedOff());
      else item.setCrossedOff(item.getCrossedOff());

      if(itemDto.getName() != null) item.setName(itemDto.getName());
      else item.setName(itemDto.getName());

      if(itemDto.getQty() != null) item.setQty(itemDto.getQty());
      else item.setQty(itemDto.getQty());

      if(itemDto.getUnit() != null) item.setUnit(itemDto.getUnit());
      else item.setUnit(item.getUnit());

      if(itemDto.getDescription() != null) item.setDescription(itemDto.getDescription());
      else item.setDescription(item.getDescription());

      item.setList(item.getList());
      resp.add("Success, item updated!");

      itemRepo.saveAndFlush(item);
    });

    return resp;
  }

  // crossOff/Uncross list item
  @Override
  @Transactional
  public List<String> toggleCrossedOff(Long itemId) {
    List<String> resp = new ArrayList<>();
    Optional<Item> itemOpt = itemRepo.findById(itemId);
    itemOpt.ifPresent(item -> {
      item.setCrossedOff(!item.getCrossedOff());
      resp.add("Success, item crossedOff is now set to " + item.getCrossedOff());
    });
    return resp;
  }

  // delete item
  @Override
  @Transactional
  public List<String> deleteItem(Long itemId) {
    List<String> resp = new ArrayList<>();
    itemRepo.deleteById(itemId);
    if (itemRepo.findById(itemId).isEmpty()) resp.add("Success, item deleted!");
    return resp;
  }

}
