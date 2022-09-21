package com.sumo.server.Database.FightData.Fight;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import lombok.Data;


@Data
public class FightDetails {
    private PersonalDetails personalDetails1;
    private PersonalDetails personalDetails2;
    private Category category;
    private boolean firstWin;
    private int round;
}
