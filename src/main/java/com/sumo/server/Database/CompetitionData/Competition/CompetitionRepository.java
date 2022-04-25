package com.sumo.server.Database.CompetitionData.Competition;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
    List<Competition> findAllBy();

    List<Competition> findCompetitionsByName(String name);
}
