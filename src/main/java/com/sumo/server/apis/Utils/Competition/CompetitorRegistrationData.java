package com.sumo.server.apis.Utils.Competition;

import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import lombok.Data;

@Data
public class CompetitorRegistrationData {
    private Competitor competitor;
    private CategoryAtCompetition categoryAtCompetition;
}
