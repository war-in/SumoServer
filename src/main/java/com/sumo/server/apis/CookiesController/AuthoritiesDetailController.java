package com.sumo.server.apis.CookiesController;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.CoachData.Coach.CoachService;
import com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach.NationalTeamMembershipOfCoach;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.userData.User.User;
import com.sumo.server.Database.userData.User.UserService;
import com.sumo.server.Seciurity.RolesInSystem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;


@RestController
@RequestMapping("/authorizationDetails")
@RequiredArgsConstructor
public class AuthoritiesDetailController {

    private final UserService userService;
    private final CoachService coachService;

    @GetMapping()
    public ResponseEntity<AuthorizationDetails> getAuthoritiesDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(authentication.getPrincipal().toString());
        AuthorizationDetails authorizationDetails = new AuthorizationDetails(user.getUsername(), new HashSet<RolesInSystem>(), new HashSet<String>(), new HashSet<String>(),new HashSet<NationalTeam>(), new HashSet<AgeCategory>());
        authentication.getAuthorities().forEach(grantedAuthority -> {
            RolesInSystem role = RolesInSystem.valueOf(grantedAuthority.getAuthority());
            updateAuthorizationDetails(role, authorizationDetails, user);
            authorizationDetails.getRoles().add(role);
        });
        return ResponseEntity.ok().body(authorizationDetails);
    }

    public void updateAuthorizationDetails(RolesInSystem role, AuthorizationDetails authorizationDetails, User user) {
        switch (role) {
            case CLUB_COACH -> {
                Coach coach = coachService.getCoachByPersonalDetails(user.getPersonalDetails());
                coachService.getClubsAdministeredByCoach(coach).stream()
                    .map(Club::getName)
                    .forEach(club -> authorizationDetails.getAdministeredClubs().add(club));
            }
            // another cases will be implemented in another stories
            case NATIONAL_COACH -> {
                Coach coach = coachService.getCoachByPersonalDetails(user.getPersonalDetails());
                coachService.getCurrentNationalTeamsTrainedByCoach(coach)
                        .forEach(nationalTeamMemberShip -> authorizationDetails.getAgeCategoriesTrainedByNationalCoach()
                        .addAll(nationalTeamMemberShip.getCategoriesTrainedBy()));
                coachService.getCurrentNationalTeamsTrainedByCoach(coach)
                    .stream().map(NationalTeamMembershipOfCoach::getNationalTeam)
                    .forEach(nationalTeam -> authorizationDetails.getTrainedNationalTeam().add(nationalTeam));
            }
            case NATIONAL_ADMIN -> {}
            case ESF_ADMIN -> {}
            case SUPER_ADMIN -> {}
        }
    }

}
