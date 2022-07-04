package com.sumo.server.apis.Fights;

import com.sumo.server.Database.FightData.Fight.Fight;
import com.sumo.server.Database.FightData.Fight.FightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fights")
@RequiredArgsConstructor
public class FightController {

    final FightService fightService;

    @GetMapping()
    public ResponseEntity<List<Fight>> getFights() {

        return ResponseEntity.ok().body(fightService.getAllFights());
    }

    @PostMapping("/save")
    public void saveFight(@RequestBody Fight fight) {
        fightService.saveFight(fight);
    }

}
