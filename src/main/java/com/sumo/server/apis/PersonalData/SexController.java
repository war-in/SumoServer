package com.sumo.server.apis.PersonalData;

import com.sumo.server.Database.StaticData.Sex.Sex;
import com.sumo.server.Database.StaticData.Sex.SexService;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sex")
@RequiredArgsConstructor
public class SexController {
    private final SexService sexService;

    @GetMapping()
    public ResponseEntity<List<Sex>> getSexes(){
        return ResponseEntity.ok().body(sexService.getAll());
    }
}
