package com.sumo.server.Database.TeamData.NationalTeam;

import com.sumo.server.Database.StaticData.Country.Country;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NationalTeamServiceImpl implements NationalTeamService {

    final NationalTeamRepository nationalTeamRepository;

    @Override
    public List<NationalTeam> getAllNationalTeams() {
        return nationalTeamRepository.findAll();
    }

    @Override
    public NationalTeam getNationalTeamByCountry(Country country) {
        return nationalTeamRepository.findNationalTeamByCountryEquals(country);
    }

    @Override
    public NationalTeam getNationalTeamById(Long id) {
        return nationalTeamRepository.findNationalTeamById(id);
    }

    @Override
    public NationalTeam save(NationalTeam nationalTeam) {
        NationalTeam result = null;
        try {
            result = nationalTeamRepository.save(nationalTeam);
        } catch (Exception error) {
            log.error(error.getMessage());
        }
        return result;
    }
}
