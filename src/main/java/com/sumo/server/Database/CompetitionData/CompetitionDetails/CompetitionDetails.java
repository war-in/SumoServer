package com.sumo.server.Database.CompetitionData.CompetitionDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

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

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "age_categories",
            joinColumns ={@JoinColumn(name = "competition_details_id")},
            inverseJoinColumns = {@JoinColumn(name = "age_category_id")})
    private List<AgeCategory> ageCategories = new ArrayList<>();

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "national_teams",
            joinColumns = {@JoinColumn(name = "COMPETITION_DETAILS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "NATIONAL_TEAM_ID")})
    private List<NationalTeam> nationalTeams = new ArrayList<>();
}

