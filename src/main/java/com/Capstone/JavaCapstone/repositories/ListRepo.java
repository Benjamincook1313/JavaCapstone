package com.Capstone.JavaCapstone.repositories;

import com.Capstone.JavaCapstone.entities.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepo extends JpaRepository<Lists, Long> {
//  @Query("select * from lists where owner_id = ?")

  @Query("select l from Lists l where l.owner.id = :userId")
  List<Lists> findAllByOwnerId(@Param("userId") Long userId);
}
