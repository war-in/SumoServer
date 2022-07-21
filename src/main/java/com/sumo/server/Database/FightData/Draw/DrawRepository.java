package com.sumo.server.Database.FightData.Draw;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrawRepository  extends JpaRepository<Draw, Integer> {
    List<Draw> getAllByCategoryAtCompetitionId(Long categoryAtCompetitionId);
}
