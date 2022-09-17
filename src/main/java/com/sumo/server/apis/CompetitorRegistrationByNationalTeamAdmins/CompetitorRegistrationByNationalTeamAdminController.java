package com.sumo.server.apis.CompetitorRegistrationByNationalTeamAdmins;

import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdminService;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/competitor-registration-by-national-team-admin")
@RequiredArgsConstructor
public class CompetitorRegistrationByNationalTeamAdminController {

    final CompetitorRegistrationByNationalTeamAdminService competitorRegistrationByNationalTeamAdminService;

    @GetMapping()
    public ResponseEntity<List<CompetitorRegistrationByNationalTeamAdmin>> getAll() {
        return ResponseEntity.ok().body(competitorRegistrationByNationalTeamAdminService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<List<CompetitorRegistrationByNationalTeamAdmin>> saveCompetitorRegistrations(@RequestBody List<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrationRequests) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competitor-registration-by-national-team-admin/save").toUriString());
        return ResponseEntity.created(uri).body(competitorRegistrationByNationalTeamAdminService.saveAll(competitorRegistrationRequests));
    }

    @PostMapping("/update")
    public ResponseEntity<List<CompetitorRegistrationByNationalTeamAdmin>> editCompetitorRegistrations(@RequestBody List<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrationRequests) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/competitor-registration-by-national-team-admin/update").toUriString());
        return ResponseEntity.created(uri).body(competitorRegistrationByNationalTeamAdminService.updateRegistrations(competitorRegistrationRequests));

    }
}
