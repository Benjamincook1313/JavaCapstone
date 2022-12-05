package com.Capstone.JavaCapstone.models;

import com.Capstone.JavaCapstone.dtos.ItemDto;
import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.entities.Item;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.itemTypes.UnitTypes;
import com.Capstone.JavaCapstone.repositories.ItemRepo;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemImpl {
  @Autowired
  private ItemRepo itemRepo;
  @Autowired
  private ListRepo listRepo;

  // add item
  @Transactional
  public List<String> addItem(Long listid, ItemDto itemDto){
    List<String> resp = new ArrayList<>();
    Optional<Lists> listOptional = listRepo.findById(listid);
    Item item = new Item(itemDto);
    if(item.getUnit() == null) item.setUnit(UnitTypes.valueOf("UNIT"));
    listOptional.ifPresent(list -> {
      item.setList(list);
      itemRepo.saveAndFlush(item);
      resp.add("Success, item added!");
    });

    return resp;
  }

  // get list items
  @Transactional
  public List<ItemDto> getAllItems(Long listId){
    List<Item> itemList = itemRepo.findAllByListId(listId);
    List<ItemDto> itemDtoList = new ArrayList<>();
    if(itemList.isEmpty()) return null;
    for(Item item: itemList){
      item.getList().getOwner().setLists(new ArrayList<>());
      itemDtoList.add(new ItemDto(item));
    }
    return itemDtoList;
  }

  // update list item
  @Transactional
  public List<String> updateItem(Long itemId, ItemDto itemDto){
    List<String> resp = new ArrayList<>();
    Optional<Item> itemOpt = itemRepo.findById(itemId);
    itemOpt.ifPresent(item -> {
      item.setCrossedOff(itemDto.getCrossedOff());
      item.setName(itemDto.getName());
      item.setQty(itemDto.getQty());
      item.setUnit(itemDto.getUnit());
      item.setDescription(itemDto.getDescription());
      item.setList(itemDto.getList());
      resp.add("Success, item updated!");

      itemRepo.saveAndFlush(item);
    });

    return resp;
  }

  // crossOff/Uncross list item
  @Transactional
  public List<String> crosssedOff(Long itemId){
    List<String> resp = new ArrayList<>();
    Optional<Item> itemOpt = itemRepo.findById(itemId);
    itemOpt.ifPresent(item -> {
      item.setCrossedOff(!item.getCrossedOff());
      resp.add("Success, item crossedOff is now set to " + item.getCrossedOff());
    });
    return resp;
  }

  // delete item
  @Transactional
  public List<String> deleteItem(Long itemId){
    List<String> resp = new ArrayList<>();
    itemRepo.deleteById(itemId);
    if(itemRepo.findById(itemId).isEmpty()) resp.add("Success, item deleted!");
    return resp;
  }

  // create interface
  // create controller methods
  // add dto constructor in entity
  // add entity constructor in dto



}
