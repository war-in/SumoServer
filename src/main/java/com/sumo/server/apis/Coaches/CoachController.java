package com.sumo.server.apis.Coaches;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.CoachData.Coach.CoachService;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
@RequiredArgsConstructor
public class CoachController {
    final CoachService coachService;
    final PersonalDetailsService personalDetailsService;

    @PostMapping("/save")
    public ResponseEntity<Coach> saveCoach(@RequestBody Coach coach) {
        return ResponseEntity.ok().body(coachService.save(coach));
    }

    @GetMapping()
    public ResponseEntity<List<Coach>> getCoaches() {
        return ResponseEntity.ok().body(coachService.getAllCoaches());
    }

    @GetMapping("/{name}&{surname}")
    public ResponseEntity<List<Coach>> getCoachesByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        List<PersonalDetails> personalDetails = personalDetailsService.getAllByNameAndSurname(name, surname);
        List<Coach> coaches = coachService.getCoachByPersonalDetails(personalDetails);
        return ResponseEntity.ok().body(coaches);
    }
}
