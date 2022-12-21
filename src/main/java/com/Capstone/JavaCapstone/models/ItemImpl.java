package com.Capstone.JavaCapstone.models;

import com.Capstone.JavaCapstone.dtos.ItemDto;
import com.Capstone.JavaCapstone.entities.Group;
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
import java.util.HashSet;
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
    if(itemDto.getCategory() == null) item.setCategory(Categories.valueOf("MISC"));
    if(itemDto.getQty() == null) item.setQty(1);
    item.setCrossedOff(false);
    listOptional.ifPresent(list -> {
      list.setItemCount(list.getItemCount() + 1);
      item.setList(list);
      itemRepo.saveAndFlush(item);
      listRepo.saveAndFlush(list);
      resp.add("Success, item added!");
    });

    return resp;
  }

  // get list items
  @Override
  @Transactional
  public List<ItemDto> getListItems(Long listId) {
    List<Item> itemList = itemRepo.findAllByListId(listId);
    if(itemList.isEmpty()) return null;
    List<ItemDto> itemDtoList = new ArrayList<>();
    for (Item item : itemList) itemDtoList.add(new ItemDto(item));
    for(ItemDto item: itemDtoList){
      item.getList().getOwner().setLists(new ArrayList<>());
      item.getList().setItems(new HashSet<>());
      if (item.getList().getGroup() != null) item.getList().setGroup(new Group());
      item.getList().getOwner().setPassword("");
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
  public List<String> deleteItem(Long itemId, Long listId) {
    List<String> resp = new ArrayList<>();
    Optional<Lists> listsOptional = listRepo.findById(listId);
    listsOptional.ifPresent(list -> {
      list.setItemCount(list.getItemCount() - 1);
      listRepo.saveAndFlush(list);
    });
    itemRepo.deleteById(itemId);
    if (itemRepo.findById(itemId).isEmpty()) resp.add("Success, item deleted!");
    return resp;
  }

}
