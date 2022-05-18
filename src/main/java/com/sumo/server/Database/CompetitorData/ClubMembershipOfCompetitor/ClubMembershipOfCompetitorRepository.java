package com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor;

import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.util.List;

public interface ClubMembershipOfCompetitorRepository {
    List<ClubMembershipOfCompetitor> getAllByClub(Club club);
    List<ClubMembershipOfCompetitor> getAll();
}
