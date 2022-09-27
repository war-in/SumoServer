package com.sumo.server.Database.CoachData.Coach;

import com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach.NationalTeamMembershipOfCoach;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;

import java.util.List;

public interface CoachService {

    List<Coach> getAllCoaches();

    List<Coach> getCoachByPersonalDetails(List<PersonalDetails> personalDetails);

    Coach getCoachByPersonalDetails(PersonalDetails personalDetails);

    List<Club> getClubsAdministeredByCoach(Coach coach);

    List<NationalTeamMembershipOfCoach> getCurrentNationalTeamsTrainedByCoach(Coach coach);

    Coach save(Coach coach);
}
