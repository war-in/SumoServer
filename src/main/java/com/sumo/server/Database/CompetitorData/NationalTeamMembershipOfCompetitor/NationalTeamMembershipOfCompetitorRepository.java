package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationalTeamMembershipOfCompetitorRepository extends JpaRepository<NationalTeamMembershipOfCompetitor, Long> {
    List<NationalTeamMembershipOfCompetitor> findAllByNationalTeam(NationalTeam nationalTeam);

    NationalTeamMembershipOfCompetitor getNationalTeamMembershipOfCompetitorByCompetitorId(Long competitorId);

    List<NationalTeamMembershipOfCompetitor> getNationalTeamMembershipOfCompetitorByCompetitorAndCategory(Competitor competitor, Category category);
}
