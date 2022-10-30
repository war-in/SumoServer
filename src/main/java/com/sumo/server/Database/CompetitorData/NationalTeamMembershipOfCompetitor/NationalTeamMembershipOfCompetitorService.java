package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.util.List;

public interface NationalTeamMembershipOfCompetitorService {

    List<Competitor> getCompetitorsFromCurrentNationalTeam(String nationalTeam);
    List<NationalTeamMembershipOfCompetitor> getMembershipsFromCurrentNationalTeam(String nationalTeam);
    Country getCountryForCompetitor(Competitor competitor);
    List<Boolean> saveNationalTeamMembershipsOfCompetitors(List<NationalTeamMembershipOfCompetitor> nationalTeamMembershipOfCompetitors);
    Boolean saveNationalTeamMembershipOfCompetitor(NationalTeamMembershipOfCompetitor nationalTeamMembershipOfCompetitor);
    List<NationalTeamMembershipOfCompetitor> getNationalMembershipForCompetitorInCategory(Competitor competitor, Category category);
}
