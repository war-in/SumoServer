package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;

import java.util.List;

public interface CompetitorService {

    List<Competitor> getAllCompetitors();
    List<Competitor> getCompetitorsByPersonalDetails(List<PersonalDetails> personalDetails);
    List<Competitor> getCompetitorsByNationalTeam(NationalTeam nationalTeam);
}
