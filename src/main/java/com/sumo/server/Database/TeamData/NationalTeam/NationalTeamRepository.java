package com.sumo.server.Database.TeamData.NationalTeam;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.StaticData.Country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalTeamRepository extends JpaRepository<NationalTeam, Integer> {
    NationalTeam findNationalTeamByCountryEquals(Country country);
}
