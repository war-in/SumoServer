package com.sumo.server.Database.RefereeData.ClassOfReferee;

import com.sumo.server.Database.CoachData.DateOfReceivingClassOfCoach.DateOfReceivingClassOfCoach;
import com.sumo.server.Database.RefereeData.DateOfReceivingClassOfReferee.DateOfReceivingClassOfReferee;
import com.sumo.server.Database.StaticData.Region.Region;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CLASSES_OF_REFEREES")
@Getter
@Setter
public class ClassOfReferee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CLASS_OF_REFEREE_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "REGION")
    private Region region;
}
