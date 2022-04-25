package com.sumo.server.Database.CompetitionData.CategoryAtCompetition;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.FightData.Draw.Draw;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoach;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES_AT_COMPETITIONS")
@Getter
@Setter
public class CategoryAtCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CATEGORY_AT_COMPETITION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COMPETITION_ID")
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy = "categoryAtCompetition")
    private Set<Draw> draws = new LinkedHashSet<>();

    @OneToMany(mappedBy = "categoryAtCompetition")
    private Set<CompetitorRegistrationByNationalTeamCoach> competitorRegistrationsByNationalTeamsCoaches = new LinkedHashSet<>();

    @OneToMany(mappedBy = "categoryAtCompetition")
    private Set<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrationsByNationalTeamsAdmins = new LinkedHashSet<>();
}
