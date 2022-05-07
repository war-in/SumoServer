package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.util.List;

public interface NationalTeamMembershipOfCompetitorRepository {
    List<NationalTeamMembershipOfCompetitor> getAllByNationalTeam(NationalTeam nationalTeam);
}
