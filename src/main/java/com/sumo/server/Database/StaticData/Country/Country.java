package com.sumo.server.Database.StaticData.Country;

import com.sumo.server.Database.StaticData.City.City;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
public class Country {

    @Id
    @Column(name = "COUNTRY")
    private String country;

    @OneToMany(mappedBy = "country")
    private Set<City> cities = new LinkedHashSet<>();

}
