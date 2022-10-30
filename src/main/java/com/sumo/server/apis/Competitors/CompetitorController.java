package com.sumo.server.apis.Competitors;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.CoachData.Coach.CoachService;
import com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor.ClubMembershipOfCompetitorService;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.CompetitorData.Competitor.CompetitorService;
import com.sumo.server.Database.CompetitorData.Competitor.CompetitorsStatus;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitorService;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsService;
import com.sumo.server.Database.userData.User.UserService;
import com.sumo.server.Seciurity.RolesInSystem;
import com.sumo.server.Time.TimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/competitors")
@RequiredArgsConstructor
public class CompetitorController {
    final CompetitorService competitorService;
    final PersonalDetailsService personalDetailsService;
    final NationalTeamMembershipOfCompetitorService nationalTeamMembershipOfCompetitorService;
    final ClubMembershipOfCompetitorService clubMembershipOfCompetitorService;
    final CoachService coachService;
    final UserService userService;

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
    public ResponseEntity<List<Competitor>> getCompetitors() {
        return ResponseEntity.ok().body(competitorService.getAllCompetitors());
    }

    @GetMapping("/{name}&{surname}")
    public ResponseEntity<List<Competitor>> getCompetitorsByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        List<PersonalDetails> personalDetails = personalDetailsService.getAllByNameAndSurname(name, surname);
        List<Competitor> competitors = competitorService.getCompetitorsByPersonalDetails(personalDetails);
        return ResponseEntity.ok().body(competitors);
    }

    @GetMapping("/nationalTeam")
    public ResponseEntity<List<Competitor>> getCompetitorsByCurrentNationalTeam(@RequestParam String nationalTeamId) {
        return ResponseEntity.ok().body(nationalTeamMembershipOfCompetitorService.getCompetitorsFromCurrentNationalTeam(nationalTeamId));
    }

    @GetMapping("/nationalTeam/memberships")
    public ResponseEntity<List<NationalTeamMembershipOfCompetitor>> getMembershipsFromCurrentNationalTeam(@RequestParam String nationalTeamId) {
        return ResponseEntity.ok().body(nationalTeamMembershipOfCompetitorService.getMembershipsFromCurrentNationalTeam(nationalTeamId));
    }

    @GetMapping("/club/{club}")
    public ResponseEntity<List<Competitor>> getCompetitorsByCurrentClub(@PathVariable Club club) {
        return ResponseEntity.ok().body(clubMembershipOfCompetitorService.getCompetitorsByCurrentClub(club));
    }
//    TODO: tutaj jest po klubie w krajuj pasuje dodać też taki endpoint ale nie tak nazwać
//    @GetMapping("/country/{country}")
//    public ResponseEntity<List<Competitor>> getCompetitorsByCountry(@PathVariable Country country) {
//        List<ClubMembershipOfCompetitor> allClubMembershipsOfCompetitors = clubMembershipOfCompetitorService.getAll();
//
//        List<Competitor> competitorsFromCountry = competitorService.getCompetitorsByCountry(country, allClubMembershipsOfCompetitors);
//
//        return ResponseEntity.ok().body(competitorsFromCountry);
//    }

    @GetMapping("/country")
    public ResponseEntity<List<Competitor>> getCompetitorsByCountry(@RequestParam String country) {
        List<PersonalDetails> personalDetailsList = personalDetailsService.getAllPersonalDetailsInCountry(country);
        List<Competitor> resultListOfCompetitors = competitorService.getCompetitorsByPersonalDetails(personalDetailsList);
        return ResponseEntity.ok().body(resultListOfCompetitors);
    }


    @PostMapping("/addNew")
    public ResponseEntity<Competitor> addNewCompetitor(@RequestBody NewCompetitorBody requestBody) {
        Club club = requestBody.getClub();
        PersonalDetails personalDetails = requestBody.getPersonalDetails();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getPrincipal().toString();

        List<RolesInSystem> roles = authentication.getAuthorities()
            .stream().map(authority -> RolesInSystem.valueOf(authority.getAuthority()))
            .toList();

        if (roles.contains(RolesInSystem.CLUB_COACH)) {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competitor/addNew").toUriString());
            Coach coach = coachService.getCoachByPersonalDetails(userService.getUser(userLogin).getPersonalDetails());
            List<Club> clubsAdministratedBy = coachService.getClubsAdministeredByCoach(coach);
            if (clubsAdministratedBy.stream().anyMatch(c -> c.getId() == club.getId())) {
                PersonalDetails personalDetailsFromDb = personalDetailsService.save(personalDetails);
                Competitor competitor = new Competitor();
                competitor.setPersonalDetails(personalDetailsFromDb);
                competitor.setStatus(CompetitorsStatus.ACTIVE);
                competitorService.save(competitor);
                clubMembershipOfCompetitorService.connectCompetitorWithClub(competitor, club, TimeTranslator.getCurrentLocalDate());
                return ResponseEntity.created(uri).body(competitor);
            }
        }
        return null;
    }
}
