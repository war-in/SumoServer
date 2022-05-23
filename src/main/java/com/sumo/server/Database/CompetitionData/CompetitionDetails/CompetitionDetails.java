package com.sumo.server.Database.CompetitionData.CompetitionDetails;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

    @ManyToMany
    private List<AgeCategory> ageCategories;

    @ManyToMany
    private List<NationalTeam> nationalTeams;
}

