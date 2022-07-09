package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.StaticData.City.City;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompetitionJson {
    private long id;


    private String name;


    private City city;


    private LocalDate startDate;


    private LocalDate endDate;

    private CompetitionType type;
}
