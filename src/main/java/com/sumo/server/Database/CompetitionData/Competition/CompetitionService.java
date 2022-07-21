package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.CompetitorData.Competitor.RegisteredCompetitorDetails;
import com.sumo.server.Database.FightData.Fight.FightDetails;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;

import java.util.List;

public interface CompetitionService {
    boolean addDetailsToCompetition(Competition competition, CompetitionDetails competitionDetails);

    Competition addDetailsToCompetition(Competition competition, CompetitionDetails competitionDetails, CompetitionType competitionType);

    Competition updateCompetition(Competition competition);

    Competition addCategoriesToCompetition(List<Category> categoryList, Competition competition);

    Competition addAgeCategoriesToCompetition(List<AgeCategory> ageCategories, Competition competition);

    Competition addRepresentationsToCompetition(List<NationalTeam> ageCategories, Competition competition);

    CompetitionDetails saveCompetitionDetails(CompetitionDetails competitionDetails);

    CompetitionType saveCompetitionType(CompetitionType competitionType);

    Competition saveCompetition(Competition competition);

    Long deleteCompetition(Competition competition);

    List<Competition> getAllCompetitions();

    Competition getCompetitionById(Long id);

    List<RegisteredCompetitorDetails> getPersonalDetailsForCompetition(Long id);

    List<FightDetails> getFightsDetailsForCompetition(Long id);
}
