package com.Capstone.JavaCapstone.models;

import com.Capstone.JavaCapstone.dtos.ListDto;
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
    userOptional.ifPresent(user -> {
      user.setPassword("");
      list.setOwner(user);
//      list.setOwner(user);
      resp.add("Success, list created");

      listRepo.saveAndFlush(list);
    });

    return resp;
  }

  // get lists
  @Override
  @Transactional
  public List<ListDto> getLists(Long userId){
    List<Lists> lists = listRepo.findAllByOwnerId(userId);
    List<ListDto> listDtoList = new ArrayList<>();
    if(lists.isEmpty()) return null;
    for(Lists list: lists){
      list.getOwner().setLists(new ArrayList<>());
      listDtoList.add(new ListDto(list));
    }
    return listDtoList;
  }

  // get single list
  @Override
  @Transactional
  public Optional<Lists> getOne(Long listId){
    Optional<Lists> listOptional = listRepo.findById(listId);
    if(listOptional.isPresent()) {
      listOptional.get().getOwner().setLists(new ArrayList<>());
      return listOptional;
    }
    return listOptional;
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
