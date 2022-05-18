package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor.ClubMembershipOfCompetitor;
import com.sumo.server.Database.StaticData.Country.Country;
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
    final PersonalDetailsRepository personalDetailsRepository;

    @Override
    public List<Competitor> getAllCompetitors() {
        return competitorRepository.findAll();
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
    public List<Competitor> getCompetitorsByCountry(Country country, List<ClubMembershipOfCompetitor> allClubMembershipsOfCompetitors) {

        return allClubMembershipsOfCompetitors.stream()
                .filter(clubMembershipOfCompetitor -> clubMembershipOfCompetitor.getClub().getCity().getCountry() == country)
                .map(ClubMembershipOfCompetitor::getCompetitor).toList();
    }

    @Override
    public Competitor save(Competitor competitor) {
        Competitor result = null;
        PersonalDetails personalDetails = personalDetailsRepository.findPersonalDetailsById(competitor.getPersonalDetails().getId());
        competitor.setPersonalDetails(personalDetails);
        competitor.setStatus(CompetitorsStatus.ACTIVE);
        try {
            result = competitorRepository.save(competitor);
        } catch (Exception error) {
            log.error(error.getMessage());
        }

        return result;
    }

    @Override
    public Competitor changeCompetitorsStatus(Competitor competitor) {
        Competitor competitorFromDB = competitorRepository.getCompetitorById(competitor.getId());
        competitorFromDB.setStatus(competitor.getStatus());

        return competitorRepository.save(competitorFromDB);
    }

}
