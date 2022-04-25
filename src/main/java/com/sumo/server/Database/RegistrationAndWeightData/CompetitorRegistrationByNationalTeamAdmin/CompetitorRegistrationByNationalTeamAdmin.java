package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.NationalTeamAdminData.NationalTeamAdmin.NationalTeamAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor.WeighedCompetitor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COMPETITORS_REGISTRATIONS_BY_NATIONAL_TEAMS_ADMINS")
@Getter
@Setter
public class CompetitorRegistrationByNationalTeamAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITOR_REGISTRATION_BY_NATIONAL_TEAM_ADMIN_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "NATIONAL_TEAM_ADMIN_ID")
    private NationalTeamAdmin nationalTeamAdmin;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_ID")
    private Competitor competitor;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_AT_COMPETITION")
    private CategoryAtCompetition categoryAtCompetition;

    @Column(name = "IS_ACCEPTED_BY_ESF_ADMIN")
    private boolean isAcceptedByESFAdmin;

    @OneToOne(mappedBy = "registration")
    private WeighedCompetitor weighedCompetitor;
}
