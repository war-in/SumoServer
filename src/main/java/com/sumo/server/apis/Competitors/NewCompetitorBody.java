package com.sumo.server.apis.Competitors;

import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import lombok.Data;

@Data
public class NewCompetitorBody {
    private Club club;
    private PersonalDetails personalDetails;
}
