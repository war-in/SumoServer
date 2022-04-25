package com.sumo.server.Database.StaticData.City;

import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.CompetitionData.Competition.Competition;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CITIES")
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CITY_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY")
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Competition> competitions = new LinkedHashSet<>();
}
