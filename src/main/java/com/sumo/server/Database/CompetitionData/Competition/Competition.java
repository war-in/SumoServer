package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.RegistrationAndWeightData.RefereeRegistration.RefereeRegistration;
import com.sumo.server.Database.StaticData.City.City;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "COMPETITIONS")
@Getter
@Setter
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITION_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "TYPE")
    private CompetitionType type;

    @OneToMany(mappedBy = "competition")
    private Set<CategoryAtCompetition> categoriesAtCompetition = new LinkedHashSet<>();

    @OneToOne(mappedBy = "competition")
    private CompetitionDetails competitionDetails;

    @OneToMany(mappedBy = "competition")
    private Set<RefereeRegistration> refereesRegistrations = new LinkedHashSet<>();
}
