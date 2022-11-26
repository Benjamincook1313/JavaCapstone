package com.Capstone.JavaCapstone.controllers;

import com.Capstone.JavaCapstone.entity.Lists;
import com.Capstone.JavaCapstone.repositories.ListsRepo;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class ListsCtrl {

private final ListsRepo repo;
private final UserRepo usersRepo;

//  @GetMapping("/lists/${userId}")
//  public void getUserLists(Long userId){
//
//  }

  @GetMapping("allLists")
  public List<Lists> all(){
    return repo.findAll();
  }

//  @PostMapping("/addList")
//  public void addList(){
//
//  }

//  @PatchMapping("/updateList")
//  public void update(long listId){
//
//  }

//  @DeleteMapping("/deleteList")
//  public void deleteList(long listId){
//
//  }
}
