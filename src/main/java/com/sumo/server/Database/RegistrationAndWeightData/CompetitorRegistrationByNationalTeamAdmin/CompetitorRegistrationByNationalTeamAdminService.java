package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin;

import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoach;

import java.util.List;

public interface CompetitorRegistrationByNationalTeamAdminService {
    List<CompetitorRegistrationByNationalTeamAdmin> saveAll(List<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrationByNationalTeamCoachList);

    List<CompetitorRegistrationByNationalTeamAdmin> updateRegistrations(List<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrationByNationalTeamAdmins);

    List<CompetitorRegistrationByNationalTeamAdmin> getAll();
}
