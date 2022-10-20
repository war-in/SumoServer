package com.sumo.server.apis.Competitions;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.Category.CategoryRepository;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetitionRepository;
import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitionData.Competition.CompetitionService;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.CompetitorData.Competitor.RegisteredCompetitorDetails;
import com.sumo.server.Database.FightData.Draw.Draw;
import com.sumo.server.Database.FightData.Draw.DrawRepository;
import com.sumo.server.Database.FightData.DrawType.DrawType;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdminRepository;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdminService;
import com.sumo.server.Database.StaticData.Region.Region;
import com.sumo.server.apis.Utils.Competition.CompetitionData;
import com.sumo.server.apis.Utils.Competition.CompetitorRegistrationData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
@RequestMapping("/competitions")
@RequiredArgsConstructor
public class CompetitionController {
    final CompetitionService competitionService;
    final CategoryAtCompetitionRepository categoryAtCompetitionRepository;
    final CategoryRepository categoryRepository;
    final CompetitorRegistrationByNationalTeamAdminRepository competitorRegistrationByNationalTeamAdminRepository;
    final DrawRepository drawRepository;

    @GetMapping()
    public ResponseEntity<List<Competition>> getCompetitions() {
        return ResponseEntity.ok().body(competitionService.getAllCompetitions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionDetails(@PathVariable Long id) {
        return ResponseEntity.ok().body(competitionService.getCompetitionById(id));
    }

    @GetMapping("/registered-competitors/{id}")
    public ResponseEntity<List<RegisteredCompetitorDetails>> getCompetitorsDetails(@PathVariable Long id){
        return ResponseEntity.ok().body(competitionService.getPersonalDetailsForCompetition(id));
    }

    @GetMapping("/fights/{id}")
    public ResponseEntity<Object> getFightsOnCompetition(@PathVariable Long id) {
        return ResponseEntity.ok().body(competitionService.getFightsDetailsForCompetition(id));
    }

    @GetMapping("/all-events")
    public ResponseEntity<List<Competition>> getCompetitionsJson() {
        return ResponseEntity.ok().body(competitionService.getAllCompetitions());
    }

    @GetMapping("/competition-data/{id}")
    public ResponseEntity<CompetitionData> getDesktopData(@PathVariable Long id) {
        return ResponseEntity.ok().body(competitionService.getCompetitionData(id));
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
