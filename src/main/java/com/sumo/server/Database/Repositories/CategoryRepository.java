package com.sumo.server.Database.Repositories;

import com.sumo.server.Database.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllBy();
}
