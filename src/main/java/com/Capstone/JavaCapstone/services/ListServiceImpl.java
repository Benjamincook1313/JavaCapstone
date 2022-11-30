package com.Capstone.JavaCapstone.services;

import com.Capstone.JavaCapstone.services.ListService;
import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.User;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import com.Capstone.JavaCapstone.repositories.UserRepo;
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
    userOptional.ifPresent(user -> {
      listDto.setOwner(user);
      resp.add("List Created");
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
  public void updateList(Long listId, ListDto listDto){
    Optional<Lists> listOptional = listRepo.findById(listId);
    listOptional.ifPresent(list -> {
      list.setType(listDto.getType());
      list.setTitle(listDto.getTitle());
      list.setGroup(listDto.getGroup());
    });
  }

  // delete list
  @Override
  @Transactional
  public void deleteList(Long listId){
    Optional<Lists> listsOptional = listRepo.findById(listId);
    listsOptional.ifPresent(list -> listRepo.delete(list));
  }
}
