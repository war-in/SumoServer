package com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.time.LocalDate;
import java.util.List;

public interface ClubMembershipOfCompetitorService {

    List<Competitor> getCompetitorsByCurrentClub(Club club);
    List<ClubMembershipOfCompetitor> getAll();
    ClubMembershipOfCompetitor connectCompetitorWithClub(Competitor competitor, Club club, LocalDate startMembershipDate);
}
