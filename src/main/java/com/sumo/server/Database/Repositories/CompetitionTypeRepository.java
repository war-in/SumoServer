package com.sumo.server.Database.Repositories;

import com.sumo.server.Database.Entities.Competition;
import com.sumo.server.Database.Entities.CompetitionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionTypeRepository extends JpaRepository<CompetitionType, Integer> {
    List<CompetitionType> findAllBy();
}
