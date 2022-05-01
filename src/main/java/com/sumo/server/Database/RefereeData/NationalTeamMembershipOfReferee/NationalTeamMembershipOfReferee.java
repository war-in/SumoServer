package com.sumo.server.Database.RefereeData.NationalTeamMembershipOfReferee;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.RefereeData.Referee.Referee;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NATIONAL_TEAM_MEMBERSHIPS_OF_REFEREES")
@Getter
@Setter
public class NationalTeamMembershipOfReferee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NATIONAL_TEAM_MEMBERSHIP_OF_REFEREE_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "NATIONAL_TEAM_ID")
    private NationalTeam nationalTeam;

    @ManyToOne
    @JoinColumn(name = "REFEREE_ID")
    private Referee referee;

    @Column(name = "MEMBERSHIP_START")
    private LocalDate membershipStart;

    @Column(name = "MEMBERSHIP_END")
    private LocalDate membershipEnd;
}
