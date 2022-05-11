package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.util.List;

public interface CompetitionService {
    boolean addDetailsToCompetitions(Competition competition, CompetitionDetails competitionDetails);

    Competition addDetailsToCompetitions(Competition competition, CompetitionDetails competitionDetails, CompetitionType competitionType);
    Competition updateCompetition(Competition competition);
    Competition addCategoriesToCompetitions(List<Category> categoryList, Competition competition);
    Competition addAgeCategoriesToCompetition(List<AgeCategory> ageCategories, Competition competition);
    Competition addRepresentationsToCompetitions(List<NationalTeam> ageCategories, Competition competition);
    CompetitionDetails saveCompetitionDetails(CompetitionDetails competitionDetails);
    CompetitionType saveCompetitionType(CompetitionType competitionType);
    Competition saveCompetition(Competition competition);
    List<Competition> getAllCompetitions();
}
