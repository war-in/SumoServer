package com.sumo.server.Database.NationalTeamAdminData.NationalTeamMembershipOfAdmin;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.NationalTeamAdminData.NationalTeamAdmin.NationalTeamAdmin;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NATIONAL_TEAM_MEMBERSHIPS_OF_ADMINS")
@Getter
@Setter
public class NationalTeamMembershipOfAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NATIONAL_TEAM_MEMBERSHIP_OF_ADMIN_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "NATIONAL_TEAM_ID")
    private NationalTeam nationalTeam;

    @ManyToOne
    @JoinColumn(name = "NATIONAL_TEAM_ADMIN_ID")
    private NationalTeamAdmin nationalTeamAdmin;

    @Column(name = "MEMBERSHIP_START")
    private LocalDate membershipStart;

    @Column(name = "MEMBERSHIP_END")
    private LocalDate membershipEnd;
}
