package com.sumo.server.Database.CoachData.Coach;

import com.sumo.server.Database.CoachData.ClubMembershipOfCoach.ClubMembershipOfCoach;
import com.sumo.server.Database.CoachData.DateOfReceivingClassOfCoach.DateOfReceivingClassOfCoach;
import com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach.NationalTeamMembershipOfCoach;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoach;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "COACHES")
@Getter
@Setter
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COACH_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;

    @OneToMany(mappedBy = "coach")
    private Set<ClubMembershipOfCoach> clubMembershipsOfCoach = new LinkedHashSet<>();

    @OneToMany(mappedBy = "coach")
    private Set<NationalTeamMembershipOfCoach> nationalTeamMembershipsOfCoach = new LinkedHashSet<>();

    @OneToMany(mappedBy = "coach")
    private Set<DateOfReceivingClassOfCoach> datesOfReceivingClassesOfCoach = new LinkedHashSet<>();

    @OneToMany(mappedBy = "nationalTeamCoach")
    private Set<CompetitorRegistrationByNationalTeamCoach> competitorRegistrations = new LinkedHashSet<>();
}
