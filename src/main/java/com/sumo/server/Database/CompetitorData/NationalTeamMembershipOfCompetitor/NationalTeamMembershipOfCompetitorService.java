package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.util.List;

public interface NationalTeamMembershipOfCompetitorService {

    List<Competitor> getCompetitorsFromCurrentNationalTeam(NationalTeam nationalTeam);
}
