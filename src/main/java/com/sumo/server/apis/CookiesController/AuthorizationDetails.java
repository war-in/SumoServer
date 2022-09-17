package com.sumo.server.apis.CookiesController;

import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Seciurity.RolesInSystem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthorizationDetails {
    String user;
    Set<RolesInSystem> roles;
    Set<String> administeredClubs;
    Set<String> administeredNationalRepresentations;
    Set<String> trainedNationalRepresentations;
}
