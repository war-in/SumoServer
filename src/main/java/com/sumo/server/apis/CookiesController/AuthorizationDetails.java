package com.sumo.server.apis.CookiesController;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthorizationDetails {
    String user;
    Set<String> administeredClubs;
    Set<String> administeredNationalRepresentations;
    Set<String> trainedNationalRepresentations;
}
