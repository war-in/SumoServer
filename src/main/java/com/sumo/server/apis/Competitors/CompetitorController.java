package com.sumo.server.apis.Competitors;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor.ClubMembershipOfCompetitor;
import com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor.ClubMembershipOfCompetitorRepository;
import com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor.ClubMembershipOfCompetitorService;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.CompetitorData.Competitor.CompetitorService;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitorService;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeamRepository;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/competitors")
@RequiredArgsConstructor
public class CompetitorController {
    final CompetitorService competitorService;
    final PersonalDetailsService personalDetailsService;
    final NationalTeamMembershipOfCompetitorService nationalTeamMembershipOfCompetitorService;
    final ClubMembershipOfCompetitorService clubMembershipOfCompetitorService;

    //this needs competitor with personal details
    @PostMapping("/save")
    public ResponseEntity<Competitor> saveCompetitor(@RequestBody Competitor competitor) {
        return ResponseEntity.ok().body(competitorService.save(competitor));
    }

    //this needs competitor with id and new status
    @PostMapping("/change-status")
    public ResponseEntity<Competitor> deleteCompetitor(@RequestBody Competitor competitor) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competitor/change-status").toUriString());
        return ResponseEntity.created(uri).body(competitorService.changeCompetitorsStatus(competitor));
    }

    @GetMapping()
    public ResponseEntity<List<Competitor>> getCompetitors(){
        return ResponseEntity.ok().body(competitorService.getAllCompetitors());
    }

    @GetMapping("/{name}&{surname}")
    public ResponseEntity<List<Competitor>> getCompetitorsByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        List<PersonalDetails> personalDetails = personalDetailsService.getAllByNameAndSurname(name, surname);
        List<Competitor> competitors = competitorService.getCompetitorsByPersonalDetails(personalDetails);
        return ResponseEntity.ok().body(competitors);
    }

    @GetMapping("/nationalTeam/{nationalTeam}")
    public ResponseEntity<List<Competitor>> getCompetitorsByCurrentNationalTeam(@PathVariable NationalTeam nationalTeam) {
        return ResponseEntity.ok().body(nationalTeamMembershipOfCompetitorService.getCompetitorsFromCurrentNationalTeam(nationalTeam));
    }

    @GetMapping("/club/{club}")
    public ResponseEntity<List<Competitor>> getCompetitorsByCurrentClub(@PathVariable Club club) {
        return ResponseEntity.ok().body(clubMembershipOfCompetitorService.getCompetitorsByCurrentClub(club));
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Competitor>> getCompetitorsByCountry(@PathVariable Country country) {
        List<ClubMembershipOfCompetitor> allClubMembershipsOfCompetitors = clubMembershipOfCompetitorService.getAll();

        List<Competitor> competitorsFromCountry = competitorService.getCompetitorsByCountry(country, allClubMembershipsOfCompetitors);

        return ResponseEntity.ok().body(competitorsFromCountry);
    }
}
