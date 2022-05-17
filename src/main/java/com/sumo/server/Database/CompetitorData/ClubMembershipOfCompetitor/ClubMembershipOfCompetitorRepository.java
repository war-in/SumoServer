package com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor;

import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubMembershipOfCompetitorRepository extends JpaRepository<ClubMembershipOfCompetitor, Long> {
    List<ClubMembershipOfCompetitor> getAllByClub(Club club);
}
