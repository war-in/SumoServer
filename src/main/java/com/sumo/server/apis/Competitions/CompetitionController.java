package com.sumo.server.apis.Competitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitionData.Competition.CompetitionJson;
import com.sumo.server.Database.CompetitionData.Competition.CompetitionService;
import com.sumo.server.Database.CompetitionData.Competition.CompetitionToJson;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/competitions")
@RequiredArgsConstructor
public class CompetitionController {
    final CompetitionService competitionService;

    @GetMapping()
    public ResponseEntity<List<Competition>> getCompetitions() {

        return ResponseEntity.ok().body(competitionService.getAllCompetitions());
    }

    @GetMapping("/all-events")
    public ResponseEntity<List<CompetitionJson>> getCompetitionsJson() {
        List<Competition> competitions = competitionService.getAllCompetitions();
        List<CompetitionJson> competitionJsons = competitions.stream().map(competition -> {
            try {
                return CompetitionToJson.getCompetitionData(competition);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        return ResponseEntity.ok().body(competitionJsons);
    }

    @PostMapping("/save")
    public ResponseEntity<Competition> saveCompetition(@RequestBody Competition competition) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competition/save").toUriString());
        CompetitionDetails competitionDetails = competitionService.saveCompetitionDetails(competition.getDetails());
        CompetitionType competitionType = competitionService.saveCompetitionType(competition.getType());
        return ResponseEntity.created(uri).body(competitionService.addDetailsToCompetition(competition, competitionDetails, competitionType));

    }

    @PostMapping("/update")
    public ResponseEntity<Competition> editCompetition(@RequestBody Competition competition) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competition/update").toUriString());
        return ResponseEntity.created(uri).body(competitionService.updateCompetition(competition));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCompetition(@RequestBody Competition competition) {
        competitionService.deleteCompetition(competition);
        return ResponseEntity.ok().build();
    }


}
