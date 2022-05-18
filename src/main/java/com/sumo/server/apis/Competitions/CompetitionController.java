package com.sumo.server.apis.Competitions;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitionData.Competition.CompetitionService;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.userData.Role.Role;
import com.sumo.server.Database.userData.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/competitions")
@RequiredArgsConstructor
public class CompetitionController {
    final CompetitionService competitionService;

    @GetMapping()
    public ResponseEntity<List<Competition>> getCompetition(){
        return ResponseEntity.ok().body(competitionService.getAllCompetitions());
    }

    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody Competition competition){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        CompetitionDetails competitionDetails = competitionService.saveCompetitionDetails(competition.getDetails());
        CompetitionType competitionType = competitionService.saveCompetitionType(competition.getType());
        competitionService.addDetailsToCompetitions(competition,competitionDetails,competitionType);
        return ResponseEntity.created(uri).build();
    }
}
