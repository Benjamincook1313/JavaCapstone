package com.Capstone.JavaCapstone.controllers;

import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import com.Capstone.JavaCapstone.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/user/{userId}")
public class ListCtrl {

  @Autowired
  private ListRepo repo;
  @Autowired
  private ListService listService;

  @GetMapping("/lists")
  public List<ListDto> getLists(@PathVariable Long userId){
    return listService.getLists(userId);
  }

  @GetMapping("/list/{listId}")
  public ListDto getOne(@PathVariable Long listId){
    return listService.getOne(listId);
  }

  @PostMapping("/list")
  public List<String> newList(@PathVariable Long userId, @RequestBody ListDto listDto){
    return listService.addList(userId, listDto);
  }

  @PatchMapping("/list/{listId}")
  public List<String> updateList(@PathVariable Long listId, @RequestBody ListDto listDto){
    return listService.updateList(listId, listDto);
  }

  @DeleteMapping("/list/{listId}")
  public List<String> deleteList(@PathVariable Long listId){
    return listService.deleteList(listId);
  }
}
