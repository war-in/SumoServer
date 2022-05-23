package com.sumo.server.Database.CompetitionData.CompetitionDetails;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionDetailsRepository extends JpaRepository<CompetitionDetails, Integer> {
    List<CompetitionDetails> findAllBy();

}
