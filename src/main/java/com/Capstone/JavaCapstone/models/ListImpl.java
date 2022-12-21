package com.Capstone.JavaCapstone.models;

import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.enums.ListTypes;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.User;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import com.Capstone.JavaCapstone.services.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ListImpl implements ListService {

  public static final Logger log = LoggerFactory.getLogger(ListImpl.class);
  @Autowired
  private ListRepo listRepo;
  @Autowired
  private UserRepo userRepo;

  // create new list
  @Override
  @Transactional
  public List<String> addList(Long userId, ListDto listDto){
    List<String> resp = new ArrayList<>();
    Optional<User> userOptional = userRepo.findById(userId);
    Lists list = new Lists(listDto);
    if(list.getType() == null) list.setType(ListTypes.valueOf("ITEM"));
    userOptional.ifPresent(user -> {
      list.setItemCount(0);
      list.setOwner(user);
//      list.getOwner().setPassword(user.getPassword());
      resp.add("Success, list created");

      listRepo.saveAndFlush(list);
    });

    return resp;
  }

  // get lists
  @Override
  @Transactional
  public List<ListDto> getLists(Long userId){
    List<Lists> listLists = listRepo.findAllByOwnerId(userId);
    List<ListDto> listDtoLists = new ArrayList<>();
    if(listLists.isEmpty()) return null;
    for(Lists list: listLists) {
      ListDto listDto = new ListDto(list);
//      listDto.getOwner().setPassword("");
      listDto.getOwner().setLists(new ArrayList<>());
      listDto.getOwner().setGroups(new HashSet<>());
      if(listDto.getGroup() != null) {
        listDto.getGroup().setAdmin1(new User());
        listDto.getGroup().setAdmin2(new User());
        listDto.getGroup().setMembers(new HashSet<>());
      }
      listDtoLists.add(listDto);
    }
    return listDtoLists;
  }

  // get single list
  @Override
  @Transactional
  public List<ListDto> getOne(Long listId){
    Optional<Lists> listOpt = listRepo.findById(listId);
    List<ListDto> listDtoList = new ArrayList<>();
    listOpt.ifPresent(list -> {
      ListDto listDto = new ListDto(list);
      listDto.getOwner().setLists(new ArrayList<>());
      listDto.getOwner().setGroups(new ArrayList<>());
      listDto.getOwner().setPassword("");
      if(listDto.getGroup() != null){
        listDto.getGroup().setAdmin1(new User());
        listDto.getGroup().setAdmin2(new User());
        listDto.getGroup().setLists(new ArrayList<>());
        listDto.getGroup().setMembers(new HashSet<>());
      }
      listDtoList.add(listDto);
    });

    return listDtoList;
  }

  // edit list patch mapping
  @Override
  @Transactional
  public List<String> updateList(Long listId, ListDto listDto){
    List<String> resp = new ArrayList<>();
    Optional<Lists> listOptional = listRepo.findById(listId);
    listOptional.ifPresent(list -> {
      if(listDto.getTitle() != null)  list.setTitle(listDto.getTitle());
      else list.setTitle(list.getTitle());

      if(listDto.getType() != null)  list.setType(listDto.getType());
      else list.setType(list.getType());

      resp.add("Success, list updated!");
      listRepo.saveAndFlush(list);
    });

    return resp;
  }

  // delete list
  @Override
  @Transactional
  public List<String> deleteList(Long listId){
    List<String> resp = new ArrayList<>();
    listRepo.deleteById(listId);
    if(listRepo.findById(listId).isEmpty()) resp.add("Success, list deleted!");

    return resp;
  }
}
