package com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClubMembershipOfCompetitorServiceImpl implements ClubMembershipOfCompetitorService {

    private final ClubMembershipOfCompetitorRepository clubMembershipOfCompetitorRepository;

    @Override
    public List<Competitor> getCompetitorsByCurrentClub(Club club) {
        List<Competitor> currentClub = new ArrayList<>();

        List<ClubMembershipOfCompetitor> clubMembershipsOfCompetitors =
                clubMembershipOfCompetitorRepository.getAllByClub(club);

        for(ClubMembershipOfCompetitor clubMembershipOfCompetitor: clubMembershipsOfCompetitors) {
            if(clubMembershipOfCompetitor.getMembershipEnd() == null)
                currentClub.add(clubMembershipOfCompetitor.getCompetitor());
        }

        return currentClub;
    }

    @Override
    public List<ClubMembershipOfCompetitor> getAll() {
        return clubMembershipOfCompetitorRepository.findAll();
    }


    @Override
    public ClubMembershipOfCompetitor connectCompetitorWithClub(Competitor competitor, Club club, LocalDate startMembershipDate) {
        ClubMembershipOfCompetitor clubMembership = new ClubMembershipOfCompetitor();
        clubMembership.setClub(club);
        clubMembership.setCompetitor(competitor);
        clubMembership.setMembershipStart(startMembershipDate);
        return clubMembershipOfCompetitorRepository.save(clubMembership);
    }
}
