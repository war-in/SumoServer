package com.sumo.server.Database.StaticData.Country;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
public class Country {

    @Id
    @Column(name = "COUNTRY")
    private String country;


}
