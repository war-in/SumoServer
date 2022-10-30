package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor.ClubMembershipOfCompetitor;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;

import java.util.List;

public interface CompetitorService {

    List<Competitor> getAllCompetitors();
    List<Competitor> getCompetitorsByPersonalDetails(List<PersonalDetails> personalDetails);
    List<Competitor> getCompetitorsByCountry(Country country, List<ClubMembershipOfCompetitor> allClubMembershipsOfCompetitors);

    Competitor save(Competitor competitor);
    Competitor getCompetitorByPersonalDetails(PersonalDetails personalDetails);

    Competitor changeCompetitorsStatus(Competitor competitor);
}
