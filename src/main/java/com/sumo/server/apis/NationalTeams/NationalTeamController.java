package com.sumo.server.apis.NationalTeams;

import com.sumo.server.Database.CompetitorData.Competitor.CompetitorService;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitorService;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/national-teams")
@RequiredArgsConstructor
public class NationalTeamController {

    final NationalTeamService nationalTeamService;
    final NationalTeamMembershipOfCompetitorService nationalTeamMembershipOfCompetitorService;
    final CompetitorService competitorService;

    @GetMapping()

    public ResponseEntity<List<NationalTeam>> getNationalTeams() {
        return ResponseEntity.ok().body(nationalTeamService.getAllNationalTeams());
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<NationalTeam> getNationalTeamByCountry(@PathVariable Long id) {
        return ResponseEntity.ok().body(nationalTeamService.getNationalTeamById(id));
    }

    @PostMapping("/saveCompetitorsMemberships")
    public ResponseEntity<List<Boolean>> saveNationalTeamMembershipForCompetitor(@RequestBody List<NationalTeamMembershipOfCompetitor> nationalTeamsMembershipsOfCompetitors) {
        List<Boolean> resultsOfSaves = new LinkedList<>();
        nationalTeamsMembershipsOfCompetitors.forEach((membership) -> {
            AtomicBoolean shouldSave = new AtomicBoolean(membership.getMembershipEnd()==null);
            AtomicBoolean resultOfSave = new AtomicBoolean(shouldSave.get());
            membership.setCompetitor(competitorService.getCompetitorByPersonalDetails(membership.getCompetitor().getPersonalDetails()));
            List<NationalTeamMembershipOfCompetitor> similarMemberships = nationalTeamMembershipOfCompetitorService.getNationalMembershipForCompetitorInCategory(membership.getCompetitor(), membership.getCategory());
            similarMemberships.forEach((similarMembership)->{
                if (membership.getMembershipEnd() != null && similarMembership.getMembershipEnd() == null){
                    similarMembership.setMembershipEnd(membership.getMembershipEnd());
                    resultOfSave.set(nationalTeamMembershipOfCompetitorService.saveNationalTeamMembershipOfCompetitor(similarMembership));
                    shouldSave.set(false);
                }
                else if (shouldSave.get() && membership.getMembershipEnd() == null && similarMembership.getMembershipEnd()==null){
                    shouldSave.set(false);
                    resultOfSave.set(false);
                }
            });
            if(shouldSave.get()){
                resultOfSave.set(nationalTeamMembershipOfCompetitorService.saveNationalTeamMembershipOfCompetitor(membership));
            }
            resultsOfSaves.add(resultOfSave.get());
        });
        return ResponseEntity.ok().body(resultsOfSaves);
    }


}
