package com.sumo.server.apis.Competitions;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitionData.Competition.CompetitionService;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.CompetitorData.Competitor.RegisteredCompetitorDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/competitions")
@RequiredArgsConstructor
public class CompetitionController {
    final CompetitionService competitionService;

    @GetMapping()
    public ResponseEntity<List<Competition>> getCompetitions() {
        return ResponseEntity.ok().body(competitionService.getAllCompetitions());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionDetails(@PathVariable Long id){
      return ResponseEntity.ok().body(competitionService.getCompetitionById(id));
    }
    @GetMapping("/registered-competitors/{id}")
    public ResponseEntity<List<RegisteredCompetitorDetails>> getCompetitorsDetails(@PathVariable Long id){
        return ResponseEntity.ok().body(competitionService.getPersonalDetailsForCompetition(id));
    }
    @GetMapping("/fights/{id}")
    public ResponseEntity<Object> getFightsOnCompetition(@PathVariable Long id){
        return ResponseEntity.ok().body(competitionService.getFightsDetailsForCompetition(id));
    }

    @GetMapping("/all-events")
    public ResponseEntity<List<Competition>> getCompetitionsJson() {
        return ResponseEntity.ok().body(competitionService.getAllCompetitions());
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
