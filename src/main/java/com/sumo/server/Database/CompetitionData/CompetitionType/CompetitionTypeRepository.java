package com.sumo.server.Database.CompetitionData.CompetitionType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionTypeRepository extends JpaRepository<CompetitionType, Integer> {
    List<CompetitionType> findAllBy();
}
