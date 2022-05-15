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
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
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

    @Override
    public boolean addDetailsToCompetitions(Competition competition, CompetitionDetails competitionDetails) {
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
    public Competition addDetailsToCompetitions(Competition competition, CompetitionDetails competitionDetails,CompetitionType competitionType) {
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
    public Competition addCategoriesToCompetitions(List<Category> categoryList, Competition competition) {
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
    public Competition addRepresentationsToCompetitions(List<NationalTeam> nationalTeams, Competition competition) {
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
    public CompetitionDetails saveCompetitionDetails(CompetitionDetails competitionDetails) {
        return competitionDetailsRepository.save(competitionDetails);
    }

    @Override
    public CompetitionType saveCompetitionType(CompetitionType competitionType) {
        return competitionTypeRepository.save(competitionType);
    }

    @Override
    public Long deleteCompetition(Competition competition) {
        competitionDetailsRepository.deleteById(competition.getDetails().getId());
        return competitionRepository.deleteById(competition.getId());
    }
}
