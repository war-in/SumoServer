package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach;

import com.sumo.server.Database.CompetitorData.Competitor.CompetitorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompetitorRegistrationByNationalTeamCoachServiceImpl implements CompetitorRegistrationByNationalTeamCoachService {
    final CompetitorRegistrationByNationalTeamCoachRepository competitorRegistrationByNationalTeamCoachRepository;

    @Override
    public List<CompetitorRegistrationByNationalTeamCoach> saveAll(List<CompetitorRegistrationByNationalTeamCoach> competitorRegistrationByNationalTeamCoachList) {
        return competitorRegistrationByNationalTeamCoachRepository.saveAll(competitorRegistrationByNationalTeamCoachList);
    }

    @Override
    public List<CompetitorRegistrationByNationalTeamCoach> updateRegistrations(List<CompetitorRegistrationByNationalTeamCoach> competitorRegistrationByNationalTeamCoaches) {
        List<Long> idsInDatabase = competitorRegistrationByNationalTeamCoachRepository.findAll().stream().map(CompetitorRegistrationByNationalTeamCoach::getId).toList();
        List<Long> idsInFrontend = competitorRegistrationByNationalTeamCoaches.stream().map(CompetitorRegistrationByNationalTeamCoach::getId).toList();
        List<Long> idsToRemove = idsInDatabase.stream().filter(idInDatabase -> !idsInFrontend.contains(idInDatabase)).toList();

        competitorRegistrationByNationalTeamCoaches.forEach(fromFrontend -> {
            if (idsInDatabase.contains(fromFrontend.getId())) {
                updateCompetitorRegistration(fromFrontend.getId(), fromFrontend);
            } else {
                addCompetitorRegistration(fromFrontend);
            }
        });
        if (!idsToRemove.isEmpty()) {
            deleteAll(idsToRemove);
        }
        return competitorRegistrationByNationalTeamCoachRepository.findAll();

    }

    @Override
    public List<CompetitorRegistrationByNationalTeamCoach> getAll() {
        return competitorRegistrationByNationalTeamCoachRepository.findAll();
    }

    @Transactional
    void updateCompetitorRegistration(long id, CompetitorRegistrationByNationalTeamCoach fromFrontend) {

        CompetitorRegistrationByNationalTeamCoach registrationByNationalTeamCoach = competitorRegistrationByNationalTeamCoachRepository.findById(id).orElseThrow();
        registrationByNationalTeamCoach.setCompetitor(fromFrontend.getCompetitor());

        competitorRegistrationByNationalTeamCoachRepository.save(registrationByNationalTeamCoach);
    }

    private CompetitorRegistrationByNationalTeamCoach addCompetitorRegistration(CompetitorRegistrationByNationalTeamCoach competitorRegistrationByNationalTeamCoach) {
        return competitorRegistrationByNationalTeamCoachRepository.save(competitorRegistrationByNationalTeamCoach);
    }

    private void deleteAll(Iterable<Long> toDelete) {
        competitorRegistrationByNationalTeamCoachRepository.deleteAllById(toDelete);
    }
}
