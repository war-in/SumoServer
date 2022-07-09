package com.sumo.server.apis.NationalTeams;

import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/national-teams")
@RequiredArgsConstructor
public class NationalTeamController {

    final NationalTeamService nationalTeamService;


    @GetMapping()
    public ResponseEntity<List<NationalTeam>> getNationalTeams(){

        return ResponseEntity.ok().body(nationalTeamService.getAllNationalTeams());
    }
    @GetMapping("/country/{country}")
    public ResponseEntity<NationalTeam> getNationalTeamByCountry(@PathVariable Country country){
        System.out.println(country);
        return ResponseEntity.ok().body(nationalTeamService.getNationalTeamByCountry(country));
    }
}
