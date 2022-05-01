package com.sumo.server.Database.CompetitionData.CategoryAtCompetition;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryAtCompetitionRepository extends JpaRepository<CategoryAtCompetition, Integer> {
    List<CategoryAtCompetition> findAllBy();
}
