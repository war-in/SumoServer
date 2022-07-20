package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategoryRepository;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.Category.CategoryRepository;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetitionRepository;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetailsRepository;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionTypeRepository;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.CompetitorData.Competitor.RegisteredCompetitorDetails;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitorRepository;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitorService;
import com.sumo.server.Database.FightData.Draw.Draw;
import com.sumo.server.Database.FightData.Draw.DrawRepository;
import com.sumo.server.Database.FightData.Fight.Fight;
import com.sumo.server.Database.FightData.Fight.FightDetails;
import com.sumo.server.Database.FightData.Fight.FightRepository;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdminRepository;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoach;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompetitionServiceImpl implements CompetitionService {

    final CompetitionRepository competitionRepository;
    final CompetitionDetailsRepository competitionDetailsRepository;
    final CategoryRepository categoryRepository;
    final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    final AgeCategoryRepository ageCategoryRepository;
    final CompetitionTypeRepository competitionTypeRepository;
    final CompetitorRegistrationByNationalTeamAdminRepository competitorRegistrationByNationalTeamAdminRepository;
    final NationalTeamMembershipOfCompetitorRepository nationalTeamMembershipOfCompetitorRepository;

    final NationalTeamMembershipOfCompetitorService nationalTeamMembershipOfCompetitorService;
    final DrawRepository drawRepository;
    final FightRepository fightRepository;

    @Override
    public boolean addDetailsToCompetition(Competition competition, CompetitionDetails competitionDetails) {
        competition.setDetails(competitionDetails);
        Competition result = null;
        try {
            result = competitionRepository.save(competition);
        } catch (Exception error) {
            log.error(error.getMessage());
        }
        return result != null;
    }
    @Override
    public Competition addDetailsToCompetition(Competition competition, CompetitionDetails competitionDetails, CompetitionType competitionType) {
        competition.setType(competitionType);
        competition.setDetails(competitionDetails);
        Competition result = null;
        try {
            result = competitionRepository.save(competition);
        } catch (Exception error) {
            log.error(error.getMessage());
        }
        return result;
    }

    @Override
    public Competition addCategoriesToCompetition(List<Category> categoryList, Competition competition) {
        List<CategoryAtCompetition> categoryAtCompetitions = new LinkedList<>();
        categoryList.forEach(category -> {
            CategoryAtCompetition categoryAtCompetition = new CategoryAtCompetition(null, competition, category);
            try {
                categoryAtCompetitionRepository.save(categoryAtCompetition);

            } catch (Exception exception) {
                log.error(exception.getMessage());
            }
        });
        return competitionRepository.findById(competition.getId());
    }

    @Override
    public Competition addAgeCategoriesToCompetition(List<AgeCategory> ageCategories, Competition competition) {
        Competition competitionFromDb = competitionRepository.findById(competition.getId());
        CompetitionDetails competitionDetails = competitionFromDb.getDetails();
        competitionDetails.getAgeCategories().addAll(ageCategories);
        try {
            competitionDetailsRepository.save(competitionDetails);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return competitionRepository.findById(competition.getId());
    }

    @Override
    public Competition addRepresentationsToCompetition(List<NationalTeam> nationalTeams, Competition competition) {
        Competition competitionFromDb = competitionRepository.findById(competition.getId());
        CompetitionDetails competitionDetails = competitionFromDb.getDetails();
        competitionDetails.getNationalTeams().addAll(nationalTeams);
        try {
            competitionDetailsRepository.save(competitionDetails);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return competitionRepository.findById(competition.getId());
    }

    @Override
    public Competition saveCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition updateCompetition(Competition competition) {
        if( competition.getDetails() != null){
            competitionDetailsRepository.save(competition.getDetails());
        }
        return competitionRepository.save(competition);

    }

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAllBy();
    }

    @Override
    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id);
    }

    @Override
    public List<RegisteredCompetitorDetails> getPersonalDetailsForCompetition(Long id) {
        List<CategoryAtCompetition> categoryAtCompetitions = categoryAtCompetitionRepository.findAllByCompetition_Id(id);
        List<RegisteredCompetitorDetails> registeredCompetitorDetails = new ArrayList<>();

        for(CategoryAtCompetition cat : categoryAtCompetitions){
            Category category = cat.getCategory();
            List<CompetitorRegistrationByNationalTeamAdmin> competitorsAtCategory = competitorRegistrationByNationalTeamAdminRepository.findAllByCategoryAtCompetition_Id(category.getId());
            List<Competitor> competitors = competitorsAtCategory.stream().map(CompetitorRegistrationByNationalTeamAdmin::getCompetitor).toList();
            List<Country> countries = new ArrayList<>();
            for(Competitor competitor: competitors){
                Country country = nationalTeamMembershipOfCompetitorService.getCountryForCompetitor(competitor);
                countries.add(country);
            }
            List<PersonalDetails> personalDetailsOfCompetitors = competitors.stream().map(Competitor::getPersonalDetails).toList();

            int index = 0;
            for (PersonalDetails personalDetails: personalDetailsOfCompetitors){
                RegisteredCompetitorDetails registeredCompetitor = new RegisteredCompetitorDetails();
                registeredCompetitor.setPersonalDetails(personalDetails);
                registeredCompetitor.setCategory(category);
                registeredCompetitor.setCountry(countries.get(index));
                registeredCompetitorDetails.add(registeredCompetitor);
                index ++;
            }


        }
        return registeredCompetitorDetails;

    }

    @Override
    public List<FightDetails> getFightsDetailsForCompetition(Long id) {
        List<FightDetails> fightDetails = new ArrayList<>();

        List<CategoryAtCompetition> categoryAtCompetitions = categoryAtCompetitionRepository.findAllByCompetition_Id(id);
        for(CategoryAtCompetition categoryAtCompetition: categoryAtCompetitions){
            Category category = categoryAtCompetition.getCategory();

            List<Draw> draws = drawRepository.getAllByCategoryAtCompetition_Id(categoryAtCompetition.getId());
            for (Draw draw: draws){
                List<Fight> fights = fightRepository.findAllByDraw_Id(draw.getId());
                for (Fight fight: fights){
                    FightDetails fightDetails1 = new FightDetails();

                    PersonalDetails personalDetails = fight.getFirstCompetitor().getPersonalDetails();
                    PersonalDetails personalDetails1 = fight.getSecondCompetitor().getPersonalDetails();

                    boolean firstWin = fight.isWinner();

                    int round = fight.getNumberOfPlaceInDraw();

                    fightDetails1.setPersonalDetails1(personalDetails);
                    fightDetails1.setPersonalDetails2(personalDetails1);
                    fightDetails1.setFirstWin(firstWin);
                    fightDetails1.setRound(round);
                    fightDetails1.setCategory(category);

                    fightDetails.add(fightDetails1);

                }
            }
        }
        return fightDetails;
    }


    @Override
    public CompetitionDetails saveCompetitionDetails(CompetitionDetails competitionDetails) {
        try {
            return competitionDetailsRepository.save(competitionDetails);
        } catch (Exception error) {
            log.error(error.getMessage());
        }
        return null;
    }

    @Override
    public CompetitionType saveCompetitionType(CompetitionType competitionType) {
        try {
            return competitionTypeRepository.save(competitionType);
        } catch (Exception error) {
            log.error(error.getMessage());
        }
        return null;
    }

    @Override
    public Long deleteCompetition(Competition competition) {
        competitionDetailsRepository.deleteById(competition.getDetails().getId());
        return competitionRepository.deleteById(competition.getId());
    }
}
