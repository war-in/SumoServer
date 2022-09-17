package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompetitorRegistrationByNationalTeamAdminServiceImpl implements CompetitorRegistrationByNationalTeamAdminService {
    final CompetitorRegistrationByNationalTeamAdminRepository competitorRegistrationByNationalTeamAdminRepository;

    @Override
    public List<CompetitorRegistrationByNationalTeamAdmin> saveAll(List<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrationByNationalTeamAdminList) {
        return competitorRegistrationByNationalTeamAdminRepository.saveAll(competitorRegistrationByNationalTeamAdminList);
    }

    @Override
    public List<CompetitorRegistrationByNationalTeamAdmin> updateRegistrations(List<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrationByNationalTeamAdmins) {
        List<Long> idsInDatabase = competitorRegistrationByNationalTeamAdminRepository.findAll().stream().map(CompetitorRegistrationByNationalTeamAdmin::getId).toList();
        List<Long> idsInFrontend = competitorRegistrationByNationalTeamAdmins.stream().map(CompetitorRegistrationByNationalTeamAdmin::getId).toList();
        List<Long> idsToRemove = idsInDatabase.stream().filter(idInDatabase -> !idsInFrontend.contains(idInDatabase)).toList();

        competitorRegistrationByNationalTeamAdmins.forEach(fromFrontend -> {
            if (idsInDatabase.contains(fromFrontend.getId())) {
                updateCompetitorRegistration(fromFrontend.getId(), fromFrontend);
            } else {
                addCompetitorRegistration(fromFrontend);
            }
        });
        if (!idsToRemove.isEmpty()) {
            deleteAll(idsToRemove);
        }
        return competitorRegistrationByNationalTeamAdminRepository.findAll();
    }

    @Transactional
    void updateCompetitorRegistration(long id, CompetitorRegistrationByNationalTeamAdmin fromFrontend) {

        CompetitorRegistrationByNationalTeamAdmin registrationByNationalTeamCoach = competitorRegistrationByNationalTeamAdminRepository.findById(id).orElseThrow();
        registrationByNationalTeamCoach.setCompetitor(fromFrontend.getCompetitor());

        competitorRegistrationByNationalTeamAdminRepository.save(registrationByNationalTeamCoach);
    }

    private CompetitorRegistrationByNationalTeamAdmin addCompetitorRegistration(CompetitorRegistrationByNationalTeamAdmin competitorRegistrationByNationalTeamCoach) {
        return competitorRegistrationByNationalTeamAdminRepository.save(competitorRegistrationByNationalTeamCoach);
    }

    private void deleteAll(Iterable<Long> toDelete) {
        competitorRegistrationByNationalTeamAdminRepository.deleteAllById(toDelete);
    }

    @Override
    public List<CompetitorRegistrationByNationalTeamAdmin> getAll() {
        return competitorRegistrationByNationalTeamAdminRepository.findAll();
    }
}
