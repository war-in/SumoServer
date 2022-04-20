package com.sumo.server.Database.Entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "LINK_TO_ORGANISATIONAL_ANNOUNCEMENT")
    private String linkToOrganisationalAnnouncement;

    @OneToMany(mappedBy = "competition")
    private Set<CategoryAtCompetition> categoriesAtCompetition = new LinkedHashSet<>();
}
