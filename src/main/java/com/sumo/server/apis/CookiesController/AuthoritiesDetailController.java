package com.sumo.server.apis.CookiesController;

import com.sumo.server.Database.CoachData.ClubMembershipOfCoach.ClubMembershipOfCoach;
import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.CoachData.Coach.CoachRepository;
import com.sumo.server.Database.CoachData.Coach.CoachService;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsRepository;
import com.sumo.server.Database.userData.User.User;
import com.sumo.server.Database.userData.User.UserRepository;
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
        AuthorizationDetails authorizationDetails = new AuthorizationDetails(user.getUsername(), new HashSet<String>(), new HashSet<String>(), new HashSet<>());
        authentication.getAuthorities().forEach(grantedAuthority -> updateAuthorizationDetails(RolesInSystem.valueOf(grantedAuthority.getAuthority()), authorizationDetails, user));
        return ResponseEntity.ok().body(authorizationDetails);
    }

    public void updateAuthorizationDetails(RolesInSystem role, AuthorizationDetails authorizationDetails, User user) {
        switch (role) {
            case CLUB_TRAINER -> {
                Coach coach = coachService.getCoachesByPersonalDetails(user.getPersonalDetails());
                coachService.getClubAdministeredByCoach(coach).stream()
                    .map(Club::getName)
                    .forEach(club -> authorizationDetails.getAdministeredClubs().add(club));
            }
            // another cases will be implemented in another stories
            case NATIONAL_TRAINER -> {}
            case NATIONAL_ADMIN -> {}
            case IFS_ADMIN -> {}
            case SUPER_ADMIN -> {}
        }
    }

}
