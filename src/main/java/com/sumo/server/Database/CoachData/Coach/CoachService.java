package com.sumo.server.Database.CoachData.Coach;

import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;

import java.util.List;

public interface CoachService {

    List<Coach> getAllCoaches();

    List<Coach> getCoachesByPersonalDetails(List<PersonalDetails> personalDetails);

    Coach getCoachesByPersonalDetails(PersonalDetails personalDetails);

    List<Club> getClubAdministeredByCoach(Coach coach);

    Coach save(Coach coach);
}
