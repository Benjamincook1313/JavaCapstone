package com.Capstone.JavaCapstone.repositories;

import com.Capstone.JavaCapstone.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
}
