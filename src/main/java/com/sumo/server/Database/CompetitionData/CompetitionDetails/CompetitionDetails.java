package com.sumo.server.Database.CompetitionData.CompetitionDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "COMPETITIONS_DETAILS")
@Getter
@Setter
public class CompetitionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITION_DETAILS_ID")
    private Long id;

    @Column(name = "COMPETITORS_REGISTRATION_START_DATE")
    private LocalDate competitorsRegistrationStartDate;

    @Column(name = "COMPETITORS_REGISTRATION_END_DATE")
    private LocalDate competitorsRegistrationEndDate;

    @Column(name = "REFEREES_REGISTRATION_START_DATE")
    private LocalDate refereesRegistrationStartDate;

    @Column(name = "REFEREES_REGISTRATION_END_DATE")
    private LocalDate refereesRegistrationEndDate;

    @Column(name = "LINK_TO_ORGANISATIONAL_ANNOUNCEMENT")
    private String linkToOrganisationalAnnouncement;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "competition_details_age_categories",
            joinColumns = {@JoinColumn(name = "competition_details_id")},
            inverseJoinColumns = {@JoinColumn(name = "age_category_id")})
    @JsonIgnoreProperties("competitionDetails")
    private List<AgeCategory> ageCategories = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "competition_details_national_teams",
            joinColumns = {@JoinColumn(name = "COMPETITION_DETAILS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "NATIONAL_TEAM_ID")})
    @JsonIgnoreProperties("competitionDetails")
    private List<NationalTeam> nationalTeams = new ArrayList<>();
}

