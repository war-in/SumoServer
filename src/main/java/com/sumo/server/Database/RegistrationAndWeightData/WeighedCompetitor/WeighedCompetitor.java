package com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor;

import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WEIGHED_COMPETITORS")
@Getter
@Setter
public class WeighedCompetitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "WEIGHED_COMPETITOR_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "COMPETITOR_REGISTRATION_BY_NATIONAL_TEAM_ADMIN_ID")
    private CompetitorRegistrationByNationalTeamAdmin registration;

    @Column(name = "WEIGHT")
    private float weight;

    @Column(name = "DATE")
    private LocalDate date;
}
