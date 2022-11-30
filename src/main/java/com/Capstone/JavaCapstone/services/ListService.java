package com.Capstone.JavaCapstone.services;

import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.entities.Lists;

import javax.transaction.Transactional;
import java.util.List;

public interface ListService {
  // create new list
  @Transactional
  List<String> addList(Long userId, ListDto listDto);

  // get lists
  @Transactional
  List<Lists> getLists(Long userId);

  // edit list patch mapping
  @Transactional
  void updateList(Long listId, ListDto listDto);

  // delete list
  @Transactional
  void deleteList(Long listId);
}
