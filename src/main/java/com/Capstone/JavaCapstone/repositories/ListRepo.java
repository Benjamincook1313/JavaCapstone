package com.Capstone.JavaCapstone.repositories;

import com.Capstone.JavaCapstone.entities.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepo extends JpaRepository<Lists, Long> {
  List<Lists> findAllByOwnerId(Long userId);
}
