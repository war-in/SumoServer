package com.sumo.server.Database.Repositories;

import com.sumo.server.Database.Entities.AgeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgeCategoryRepository extends JpaRepository<AgeCategory, Integer> {
    List<AgeCategory> findAllBy();
}
