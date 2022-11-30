package com.Capstone.JavaCapstone.controllers;

import com.Capstone.JavaCapstone.dtos.ListDto;
import com.Capstone.JavaCapstone.services.ListService;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/user/{userId}")
public class ListCtrl {

  @Autowired
  private ListRepo repo;
  @Autowired
  private ListService service;

  @GetMapping("/lists")
  public List<Lists> getLists(@PathVariable Long userId){
    return service.getLists(userId);
  }

  @PostMapping(value="/list", consumes={"application/json"})
  public List<String> addList(@PathVariable Long userId, @RequestBody ListDto listDto){
    System.out.println("Adding list");
    return service.addList(userId, listDto);
  }

//  @PatchMapping("/list/{listId}")
//  public void update(long listId){
//
//  }

//  @DeleteMapping("/list")
//  public void deleteList(long listId){
//
//  }
}
