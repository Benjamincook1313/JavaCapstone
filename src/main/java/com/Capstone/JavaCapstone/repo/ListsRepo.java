package com.Capstone.JavaCapstone.repo;

import com.Capstone.JavaCapstone.entity.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListsRepo extends JpaRepository<Lists, Long> {
}
