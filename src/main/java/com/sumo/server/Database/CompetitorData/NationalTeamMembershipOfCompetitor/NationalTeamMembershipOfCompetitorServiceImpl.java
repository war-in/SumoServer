package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NationalTeamMembershipOfCompetitorServiceImpl implements NationalTeamMembershipOfCompetitorService {

    private final NationalTeamMembershipOfCompetitorRepository nationalTeamMembershipOfCompetitorRepository;
    private final NationalTeamRepository nationalTeamRepository;

    @Override
    public List<Competitor> getCompetitorsFromCurrentNationalTeam(String nationalTeamId) {
        List<Competitor> currentNationalTeam = new ArrayList<>();
        NationalTeam nationalTeamFromDb = nationalTeamRepository.findNationalTeamById(Long.parseLong(nationalTeamId));
        List<NationalTeamMembershipOfCompetitor> nationalTeamMembershipsOfCompetitors =
            nationalTeamMembershipOfCompetitorRepository.findAllByNationalTeam(nationalTeamFromDb);

        for (NationalTeamMembershipOfCompetitor nationalTeamMembershipOfCompetitor : nationalTeamMembershipsOfCompetitors) {
            if (nationalTeamMembershipOfCompetitor.getMembershipEnd() == null)
                currentNationalTeam.add(nationalTeamMembershipOfCompetitor.getCompetitor());
        }

        return currentNationalTeam;
    }

    @Override
    public List<NationalTeamMembershipOfCompetitor> getMembershipsFromCurrentNationalTeam(String nationalTeamId) {
        List<NationalTeamMembershipOfCompetitor> currentNationalTeam = new ArrayList<>();
        NationalTeam nationalTeamFromDb = nationalTeamRepository.findNationalTeamById(Long.parseLong(nationalTeamId));
        List<NationalTeamMembershipOfCompetitor> nationalTeamMembershipsOfCompetitors =
            nationalTeamMembershipOfCompetitorRepository.findAllByNationalTeam(nationalTeamFromDb);

        for (NationalTeamMembershipOfCompetitor nationalTeamMembershipOfCompetitor : nationalTeamMembershipsOfCompetitors) {
            if (nationalTeamMembershipOfCompetitor.getMembershipEnd() == null)
                currentNationalTeam.add(nationalTeamMembershipOfCompetitor);
        }
        return currentNationalTeam;
    }

    @Override
    public Country getCountryForCompetitor(Competitor competitor) {
        NationalTeamMembershipOfCompetitor nationalTeamMembershipOfCompetitor = nationalTeamMembershipOfCompetitorRepository.getNationalTeamMembershipOfCompetitorByCompetitorId(competitor.getId());
        return nationalTeamMembershipOfCompetitor.getNationalTeam().getCountry();
    }

    @Override
    public List<Boolean> saveNationalTeamMembershipsOfCompetitors(List<NationalTeamMembershipOfCompetitor> nationalTeamMembershipOfCompetitors) {
        int index = 0;
        List<Boolean> result = new LinkedList<>();
        nationalTeamMembershipOfCompetitors.forEach((membership) -> {
            try {
                nationalTeamMembershipOfCompetitorRepository.save(membership);
                result.add(true);
            } catch (Exception ex) {
                result.add(false);
            }
        });
        return result;
    }

    @Override
    public List<NationalTeamMembershipOfCompetitor> getNationalMembershipForCompetitorInCategory(Competitor competitor, Category category) {
        return nationalTeamMembershipOfCompetitorRepository.getNationalTeamMembershipOfCompetitorByCompetitorAndCategory(competitor, category);
    }

    @Override
    public Boolean saveNationalTeamMembershipOfCompetitor(NationalTeamMembershipOfCompetitor nationalTeamMembershipOfCompetitor) {
        try {
            nationalTeamMembershipOfCompetitorRepository.save(nationalTeamMembershipOfCompetitor);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
