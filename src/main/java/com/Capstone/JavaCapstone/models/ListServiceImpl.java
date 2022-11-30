package com.Capstone.JavaCapstone.models;

import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.User;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import com.Capstone.JavaCapstone.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListServiceImpl implements ListService {
  @Autowired
  private UserRepo userRepo;
  @Autowired
  private ListRepo listRepo;
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
      resp.add("List Created");

      listRepo.saveAndFlush(list);
    });

    return resp;
  }

  // get lists
  @Override
  @Transactional
  public List<Lists> getLists(Long userId){
    return listRepo.findAllByOwnerId(userId);
  }

  // edit list patch mapping
  @Override
  @Transactional
  public List<String> updateList(Long listId, ListDto listDto){
    List<String> resp = new ArrayList<>();
    Optional<Lists> listOptional = listRepo.findById(listId);
    Lists lists = new Lists(listDto);

    // ask about updating info using PATCH instead of PUT
    listOptional.ifPresent(list -> {
      lists.setType(list.getType());
      lists.setTitle(list.getTitle());
      lists.setGroup(list.getGroup());
      lists.setOwner(list.getOwner());
      resp.add("List updated!");
      listRepo.saveAndFlush(lists);
    });

    return resp;
  }

  // delete list
  @Override
  @Transactional
  public List<String> deleteList(Long listId){
    List<String> resp = new ArrayList<>();
    Optional<Lists> listsOptional = listRepo.findById(listId);
    listsOptional.ifPresent(list -> {
      listRepo.delete(list);
      resp.add("List deleted!");
    });
    return resp;
  }
}
