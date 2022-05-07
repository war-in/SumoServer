package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitorRepository extends JpaRepository<Competitor, Integer> {

    List<Competitor> findAllBy();
    Competitor findCompetitorByPersonalDetails(PersonalDetails personalDetails);
}
