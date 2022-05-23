package com.sumo.server.Database.CoachData.Coach;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;

import java.util.List;

public interface CoachService {

    List<Coach> getAllCoaches();

    List<Coach> getCoachesByPersonalDetails(List<PersonalDetails> personalDetails);

    Coach save(Coach coach);
}
