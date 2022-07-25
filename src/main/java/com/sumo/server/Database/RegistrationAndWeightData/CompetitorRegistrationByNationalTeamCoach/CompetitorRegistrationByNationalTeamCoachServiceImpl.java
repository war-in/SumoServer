package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach;

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
    public List<CompetitorRegistrationByNationalTeamCoach> getAll() {
        return competitorRegistrationByNationalTeamCoachRepository.findAll();
    }
}
