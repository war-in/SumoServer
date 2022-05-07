package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NationalTeamMembershipOfCompetitorServiceImpl implements NationalTeamMembershipOfCompetitorService{

    private final NationalTeamMembershipOfCompetitorRepository nationalTeamMembershipOfCompetitorRepository;

    @Override
    public List<Competitor> getCompetitorsFromCurrentNationalTeam(NationalTeam nationalTeam) {
        List<Competitor> currentNationalTeam = new ArrayList<>();

        List<NationalTeamMembershipOfCompetitor> nationalTeamMembershipsOfCompetitors =
                nationalTeamMembershipOfCompetitorRepository.getAllByNationalTeam(nationalTeam);

        for(NationalTeamMembershipOfCompetitor nationalTeamMembershipOfCompetitor: nationalTeamMembershipsOfCompetitors) {
            if(nationalTeamMembershipOfCompetitor.getMembershipEnd() == null)
                currentNationalTeam.add(nationalTeamMembershipOfCompetitor.getCompetitor());
        }

        return currentNationalTeam;
    }
}
