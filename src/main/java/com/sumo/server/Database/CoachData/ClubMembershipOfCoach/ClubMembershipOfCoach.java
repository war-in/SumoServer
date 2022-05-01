package com.sumo.server.Database.CoachData.ClubMembershipOfCoach;

import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.CoachData.Coach.Coach;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLUB_MEMBERSHIPS_OF_COACHES")
@Getter
@Setter
public class ClubMembershipOfCoach {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CLUB_MEMBERSHIP_OF_COACH_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CLUB_ID")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "COACH_ID")
    private Coach coach;

    @Column(name = "MEMBERSHIP_START")
    private LocalDate membershipStart;

    @Column(name = "MEMBERSHIP_END")
    private LocalDate membershipEnd;
}
