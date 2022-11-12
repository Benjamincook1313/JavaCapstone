package com.Capstone.JavaCapstone.repo;

import com.Capstone.JavaCapstone.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Long> {
}
