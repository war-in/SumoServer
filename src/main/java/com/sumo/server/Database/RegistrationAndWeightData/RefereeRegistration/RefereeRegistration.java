package com.sumo.server.Database.RegistrationAndWeightData.RefereeRegistration;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.RefereeData.Referee.Referee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "REFEREES_REGISTRATIONS")
@Getter
@Setter
public class RefereeRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "REFEREE_REGISTRATION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COMPETITION_ID")
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "REFEREE_ID")
    private Referee referee;

    @ManyToOne
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "IS_ACCEPTED")
    private boolean isAccepted;

    @Column(name = "COMMENTS")
    private String comments;
}
