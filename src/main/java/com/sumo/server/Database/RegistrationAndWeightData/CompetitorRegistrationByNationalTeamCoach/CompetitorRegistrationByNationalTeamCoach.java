package com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMPETITORS_REGISTRATIONS_BY_NATIONAL_TEAMS_COACHES")
@Getter
@Setter
public class CompetitorRegistrationByNationalTeamCoach {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITOR_REGISTRATION_BY_NATIONAL_TEAM_COACH_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COACH_ID")
    private Coach nationalTeamCoach;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_ID")
    private Competitor competitor;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_AT_COMPETITION")
    private CategoryAtCompetition categoryAtCompetition;
}
