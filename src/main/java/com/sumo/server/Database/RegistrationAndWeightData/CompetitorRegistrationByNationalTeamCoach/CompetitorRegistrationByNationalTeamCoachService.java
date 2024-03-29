package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach;

import java.util.List;

public interface CompetitorRegistrationByNationalTeamCoachService {
    List<CompetitorRegistrationByNationalTeamCoach> saveAll(List<CompetitorRegistrationByNationalTeamCoach> competitorRegistrationByNationalTeamCoachList);

    List<CompetitorRegistrationByNationalTeamCoach> updateRegistrations(List<CompetitorRegistrationByNationalTeamCoach> competitorRegistrationByNationalTeamCoaches);

    List<CompetitorRegistrationByNationalTeamCoach> getAll();
}
