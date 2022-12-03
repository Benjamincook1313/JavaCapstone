package com.Capstone.JavaCapstone.repositories;

import com.Capstone.JavaCapstone.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

  @Query("select i from Item i where i.list.id = :listId")
  List<Item> findAllByListId(Long listId);
}
