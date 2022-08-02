package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import lombok.Data;

@Data
public class CompetitorRegistrationByNationalTeamCoachRequest {
    private Competitor competitor;
}
