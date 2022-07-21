package com.sumo.server.apis.CookiesController;

import com.sumo.server.Seciurity.RolesInSystem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/authorizationDetails")
@RequiredArgsConstructor
public class AuthoritiesDetailController {

    @GetMapping()
    public ResponseEntity<AuthorizationDetails> getAuthoritiesDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getPrincipal().toString();

        AuthorizationDetails authorizationDetails = new AuthorizationDetails(user,new HashSet<String>(),new HashSet<String>(),new HashSet<>());
        authentication.getAuthorities().forEach(grantedAuthority -> updateAuthorizationDetails(RolesInSystem.valueOf(grantedAuthority.getAuthority()),authorizationDetails));
        return ResponseEntity.ok().body(authorizationDetails);
    }

    public void updateAuthorizationDetails(RolesInSystem role, AuthorizationDetails authorizationDetails){
        switch (role){
            case CLUB_TRAINER -> {}
            case NATIONAL_TRAINER -> {}
            case NATIONAL_ADMIN -> {}
            case IFS_ADMIN -> {}
            case SUPER_ADMIN -> {}
        }
    }

}
