package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;

import java.util.List;

public interface CompetitionService {
    boolean addDetailsToCompetitions(Competition competition, CompetitionDetails competitionDetails);

    boolean addDetailsToCompetitions(Competition competition, CompetitionDetails competitionDetails, CompetitionType competitionType);

    void addCategoriesToCompetitions(List<Category> categoryList, Competition competition);
    boolean addAgeCategoriesToCompetition(List<AgeCategory> ageCategories, Competition competition);
    boolean addRepresentationsToCompetitions(List<NationalTeam> ageCategories, Competition competition);
    CompetitionDetails saveCompetitionDetails(CompetitionDetails competitionDetails);
    CompetitionType saveCompetitionType(CompetitionType competitionType);
    Competition saveCompetition(Competition competition);
    List<Competition> getAllCompetitions();
}
