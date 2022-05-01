package com.sumo.server.Database.CompetitionData.CompetitionDetails;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "COMPETITIONS_DETAILS")
@Getter
@Setter
public class CompetitionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITION_DETAILS_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "COMPETITION_ID")
    private Competition competition;

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
}

