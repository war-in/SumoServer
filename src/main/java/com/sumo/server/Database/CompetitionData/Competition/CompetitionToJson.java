package com.sumo.server.Database.CompetitionData.Competition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompetitionToJson {
    public static CompetitionJson getCompetitionData(Competition competition) throws JsonProcessingException {
        CompetitionJson competitionJson = new CompetitionJson();

        competitionJson.setId(competition.getId());
        competitionJson.setName(competition.getName());
        competitionJson.setCity(competition.getCity());
        competitionJson.setStartDate(competition.getStartDate());
        competitionJson.setEndDate(competition.getEndDate());
        competitionJson.setType(competition.getType());

        return  competitionJson;
    }
}
