package com.sumo.server.Database.StaticData.Sex;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;

import java.util.List;

public interface SexService {
    List<Sex> getAll();
    Sex findSexByName(String sex);
}
