package com.sumo.server.Database.StaticData.Country;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sumo.server.Database.StaticData.City.City;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class,
        property = "country",
        scope = Country.class)
public class Country {

    @Id
    @Column(name = "COUNTRY")
    private String country;

    @OneToMany(mappedBy = "country")
    //@JsonBackReference
    //problem z JsonBackReference przy próbie zapisu
    private Set<City> cities = new LinkedHashSet<>();

}
