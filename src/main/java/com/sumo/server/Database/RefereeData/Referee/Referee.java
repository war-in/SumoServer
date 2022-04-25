package com.sumo.server.Database.RefereeData.Referee;

import com.sumo.server.Database.CoachData.DateOfReceivingClassOfCoach.DateOfReceivingClassOfCoach;
import com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach.NationalTeamMembershipOfCoach;
import com.sumo.server.Database.RefereeData.DateOfReceivingClassOfReferee.DateOfReceivingClassOfReferee;
import com.sumo.server.Database.RefereeData.NationalTeamMembershipOfReferee.NationalTeamMembershipOfReferee;
import com.sumo.server.Database.RegistrationAndWeightData.RefereeRegistration.RefereeRegistration;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "REFEREES")
@Getter
@Setter
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "REFEREE_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;

    @OneToMany(mappedBy = "referee")
    private Set<DateOfReceivingClassOfReferee> datesOfReceivingClassesOfReferee = new LinkedHashSet<>();

    @OneToMany(mappedBy = "referee")
    private Set<NationalTeamMembershipOfReferee> nationalTeamMembershipsOfReferee = new LinkedHashSet<>();

    @OneToMany(mappedBy = "referee")
    private Set<RefereeRegistration> refereeRegistrations = new LinkedHashSet<>();
}