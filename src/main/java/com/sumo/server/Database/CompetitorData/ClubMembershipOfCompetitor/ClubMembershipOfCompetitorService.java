package com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.util.List;

public interface ClubMembershipOfCompetitorService {

    List<Competitor> getCompetitorsByCurrentClub(Club club);
    List<ClubMembershipOfCompetitor> getAll();
}
