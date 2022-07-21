package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.StaticData.City.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DetailsForCompetition {
    private long id;
    private String name;
    private City city;
    private LocalDate startDate;
    private LocalDate endDate;
    private CompetitionType competitionType;

}
