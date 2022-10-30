package com.sumo.server.Database.CompetitionData.AgeCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgeCategoryRepository extends JpaRepository<AgeCategory, Integer> {
    List<AgeCategory> findAllBy();

    AgeCategory getAgeCategoryById(long id);
}
