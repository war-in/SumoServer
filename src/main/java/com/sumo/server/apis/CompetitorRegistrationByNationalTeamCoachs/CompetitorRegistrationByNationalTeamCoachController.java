package com.sumo.server.apis.CompetitorRegistrationByNationalTeamCoachs;

import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoach;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/competitor-registration-by-national-team-coach")
@RequiredArgsConstructor
public class CompetitorRegistrationByNationalTeamCoachController {
    final CompetitorRegistrationByNationalTeamCoachService competitorRegistrationByNationalTeamCoachService;

    @GetMapping()
    public ResponseEntity<List<CompetitorRegistrationByNationalTeamCoach>> getAll() {
        return ResponseEntity.ok().body(competitorRegistrationByNationalTeamCoachService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<List<CompetitorRegistrationByNationalTeamCoach>> saveCompetitorRegistrations(@RequestBody List<CompetitorRegistrationByNationalTeamCoach> competitorRegistrationRequests) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competitor-registration-by-national-team-coach/save").toUriString());
        return ResponseEntity.created(uri).body(competitorRegistrationByNationalTeamCoachService.saveAll(competitorRegistrationRequests));
    }

    @PostMapping("/update")
    public ResponseEntity<List<CompetitorRegistrationByNationalTeamCoach>> editCompetitorRegistrations(@RequestBody List<CompetitorRegistrationByNationalTeamCoach> competitorRegistrationRequests) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competitor-registration-by-national-team-coach/update").toUriString());
        return ResponseEntity.created(uri).body(competitorRegistrationByNationalTeamCoachService.updateRegistrations(competitorRegistrationRequests));

    }
}
