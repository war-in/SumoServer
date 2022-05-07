package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompetitorServiceImpl implements CompetitorService {

    final CompetitorRepository competitorRepository;

    @Override
    public List<Competitor> getAllCompetitors() {
        return competitorRepository.findAllBy();
    }

    @Override
    public List<Competitor> getCompetitorsByPersonalDetails(List<PersonalDetails> personalDetails) {
        List<Competitor> competitors = new ArrayList<>();
        for(PersonalDetails pDetails: personalDetails) {
            competitors.add(competitorRepository.findCompetitorByPersonalDetails(pDetails));
        }

        return competitors;
    }

    @Override
    public List<Competitor> getCompetitorsByNationalTeam(NationalTeam nationalTeam) {
        return null;
    }

}
