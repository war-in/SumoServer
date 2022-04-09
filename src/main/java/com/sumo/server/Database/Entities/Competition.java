package com.sumo.server.Database.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Competitions")
@Getter
@Setter
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "type")
    private CompetitionType type;

    @Column(name = "link_to_organisational_announcement")
    private String linkToOrganisationalAnnouncement;

    @OneToMany(mappedBy = "competition")
    private Set<CategoryAtCompetition> categoriesAtCompetition;
}
