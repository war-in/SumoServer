package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin;

import com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor.WeighedCompetitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitorRegistrationByNationalTeamAdminRepository extends JpaRepository<CompetitorRegistrationByNationalTeamAdmin, Long> {
    List<CompetitorRegistrationByNationalTeamAdmin> findAllByCategoryAtCompetitionId(Long categoryAtCompetitionId);
}
