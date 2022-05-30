package com.sumo.server.Database.CompetitionData.CategoryAtCompetition;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.FightData.Draw.Draw;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoach;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES_AT_COMPETITIONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAtCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CATEGORY_AT_COMPETITION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMPETITION_ID")
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
