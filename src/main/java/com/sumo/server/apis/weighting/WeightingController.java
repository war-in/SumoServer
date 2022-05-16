package com.sumo.server.apis.weighting;


import com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor.WeighedCompetitor;
import com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor.WeighedCompetitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weighing")
@RequiredArgsConstructor
public class WeightingController {
    final WeighedCompetitorService weighedCompetitorService;

    @PostMapping("/save")
    public void saveWeighting(@RequestBody WeighedCompetitor weighedCompetitor) {
        weighedCompetitorService.saveWeighedCompetitor(weighedCompetitor);
    }
}
