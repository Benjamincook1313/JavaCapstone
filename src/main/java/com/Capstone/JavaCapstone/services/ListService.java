package com.Capstone.JavaCapstone.services;

import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.entities.Lists;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ListService {
  // create new list
  @Transactional
  List<String> addList(Long userId, ListDto listDto);

  // get lists
  @Transactional
  List<ListDto> getLists(Long userId);

  // edit list patch mapping
  @Transactional
  List<String> updateList(Long listId, ListDto listDto);

  // delete list
  @Transactional
  List<String> deleteList(Long listId);

  ListDto getOne(Long listId);
}
