package com.sumo.server.Database.CompetitionData.CompetitionType;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "COMPETITION_TYPES")
@Getter
@Setter
public class CompetitionType {

    @Id
    @Column(name = "TYPE")
    private String type;
}
