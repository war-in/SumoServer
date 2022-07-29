package com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "NATIONAL_TEAM_MEMBERSHIPS_OF_COACHES")
@Getter
@Setter
public class NationalTeamMembershipOfCoach {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NATIONAL_TEAM_MEMBERSHIP_OF_COACH_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "NATIONAL_TEAM_ID")
    private NationalTeam nationalTeam;

    @ManyToOne
    @JoinColumn(name = "COACH_ID")
    private Coach coach;

    @Column(name = "MEMBERSHIP_START")
    private LocalDate membershipStart;

    @Column(name = "MEMBERSHIP_END")
    private LocalDate membershipEnd;

    @ManyToMany(fetch = FetchType.EAGER)
    List<AgeCategory> categoriesTrainedBy;
}
