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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    final ClubMembershipOfCompetitorRepository clubMembershipOfCompetitorRepository;

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

    @GetMapping("/{nationalTeam}")
    public ResponseEntity<List<Competitor>> getCompetitorsByCurrentNationalTeam(@PathVariable NationalTeam nationalTeam) {
        return ResponseEntity.ok().body(nationalTeamMembershipOfCompetitorService.getCompetitorsFromCurrentNationalTeam(nationalTeam));
    }

    @GetMapping("/{club}")
    public ResponseEntity<List<Competitor>> getCompetitorsByCurrentClub(@PathVariable Club club) {
        return ResponseEntity.ok().body(clubMembershipOfCompetitorService.getCompetitorsByCurrentClub(club));
    }

    @GetMapping("/{country}")
    public ResponseEntity<List<Competitor>> getCompetitorsByCountry(@PathVariable Country country) {
        List<ClubMembershipOfCompetitor> allClubMembershipsOfCompetitors = clubMembershipOfCompetitorRepository.getAll();
        List<Competitor> competitorsFromCountry = new ArrayList<>();

        for(ClubMembershipOfCompetitor clubMembershipOfCompetitor: allClubMembershipsOfCompetitors) {
            if(clubMembershipOfCompetitor.getClub().getCity().getCountry()== country)
                competitorsFromCountry.add(clubMembershipOfCompetitor.getCompetitor());
        }

        return ResponseEntity.ok().body(competitorsFromCountry);
    }
}
