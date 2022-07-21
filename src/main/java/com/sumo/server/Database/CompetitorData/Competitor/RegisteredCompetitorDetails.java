package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import lombok.Data;

@Data
public class RegisteredCompetitorDetails {
    private PersonalDetails personalDetails;
    private Country country;
    private Category category;
}
