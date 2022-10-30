package com.sumo.server.Database.TeamData.NationalTeam;

import com.sumo.server.Database.StaticData.Country.Country;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NATIONAL_TEAMS")
@Getter
@Setter
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NATIONAL_TEAM_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "COUNTRY")
    private Country country;
}
