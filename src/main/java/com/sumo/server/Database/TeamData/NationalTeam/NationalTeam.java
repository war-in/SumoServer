package com.sumo.server.Database.TeamData.NationalTeam;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.NationalTeamAdminData.NationalTeamMembershipOfAdmin.NationalTeamMembershipOfAdmin;
import com.sumo.server.Database.RefereeData.NationalTeamMembershipOfReferee.NationalTeamMembershipOfReferee;
import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach.NationalTeamMembershipOfCoach;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "nationalTeams")
    List<CompetitionDetails> competitionDetails = new ArrayList<>();
}
