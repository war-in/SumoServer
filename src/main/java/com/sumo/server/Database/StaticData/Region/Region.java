package com.sumo.server.Database.StaticData.Region;

import com.sumo.server.Database.CoachData.ClassOfCoach.ClassOfCoach;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.FightData.DrawType.DrawType;
import com.sumo.server.Database.RefereeData.ClassOfReferee.ClassOfReferee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "REGIONS")
@Getter
@Setter
public class Region {

    @Id
    @Column(name = "REGION")
    private String region;
}
