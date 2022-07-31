package com.sumo.server.apis.CookiesController;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import com.sumo.server.Seciurity.RolesInSystem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthorizationDetails {
    String user;
    Set<RolesInSystem> roles;
    Set<Club> administeredClubs;
    Set<String> administeredNationalRepresentations;
    Set<NationalTeam> trainedNationalRepresentations;
    Set<AgeCategory> ageCategoriesTrainedByNationalCoach;
}
