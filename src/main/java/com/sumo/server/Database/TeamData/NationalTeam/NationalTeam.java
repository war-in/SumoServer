package com.sumo.server.Database.TeamData.NationalTeam;

import com.sumo.server.Database.NationalTeamAdminData.NationalTeamMembershipOfAdmin.NationalTeamMembershipOfAdmin;
import com.sumo.server.Database.RefereeData.NationalTeamMembershipOfReferee.NationalTeamMembershipOfReferee;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach.NationalTeamMembershipOfCoach;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "NATIONAL_TEAMS")
@Getter
@Setter
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NATIONAL_TEAM_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "COUNTRY")
    private Country country;
}
