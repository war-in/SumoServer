package com.sumo.server.Database.Repositories;

import com.sumo.server.Database.Entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
    List<Competition> findAllBy();
}
