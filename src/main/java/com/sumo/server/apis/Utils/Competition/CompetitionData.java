package com.sumo.server.apis.Utils.Competition;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.FightData.DrawType.DrawType;
import com.sumo.server.Database.StaticData.Region.Region;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CompetitionData {
    private Competition competition;
    private CompetitionType competitionType;
    private List<AgeCategory> ageCategory;
    private List<Category> category;
    private List<CategoryAtCompetition> categoryAtCompetition;
    private List<CompetitorRegistrationData> competitorRegistrationData;
    private List<DrawType> drawType;
    private List<Region> regions;

    public CompetitionData(Competition competition, CompetitionType competitionType, List<AgeCategory> ageCategory, List<Category> category, List<CategoryAtCompetition> categoryAtCompetition, List<CompetitorRegistrationData> competitorRegistrationData, List<DrawType> drawType, List<Region> regions) {
        this.competition = competition;
        this.competitionType = competitionType;
        this.ageCategory = ageCategory;
        this.category = category;
        this.categoryAtCompetition = categoryAtCompetition;
        this.competitorRegistrationData = competitorRegistrationData;
        this.drawType = drawType;
        this.regions = regions;
    }

}
