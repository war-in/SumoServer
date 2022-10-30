package com.sumo.server.Database.TeamData.NationalTeam;

import com.sumo.server.Database.StaticData.Country.Country;

import java.util.List;

public interface NationalTeamService {

    List<NationalTeam> getAllNationalTeams();
    NationalTeam getNationalTeamByCountry(Country country);
    NationalTeam getNationalTeamById(Long id);

    NationalTeam save(NationalTeam nationalTeam);

}
