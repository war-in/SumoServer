package com.sumo.server.Database.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Competition_types")
@Getter
@Setter
public class CompetitionType {

    @Id
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "type")
    private Set<Competition> competitions;
}
