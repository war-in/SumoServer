package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationalTeamMembershipOfCompetitorRepository extends JpaRepository<NationalTeamMembershipOfCompetitor, Long> {
    List<NationalTeamMembershipOfCompetitor> getAllByNationalTeam(NationalTeam nationalTeam);
    NationalTeamMembershipOfCompetitor getNationalTeamMembershipOfCompetitorByCompetitor_Id(Long competitor_id);
}
