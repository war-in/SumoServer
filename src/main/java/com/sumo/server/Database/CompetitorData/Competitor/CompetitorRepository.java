package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitorRepository extends JpaRepository<Competitor, Long> {

    Competitor findCompetitorByPersonalDetails(PersonalDetails personalDetails);
    Competitor getCompetitorById(Long id);
}
