package com.sumo.server.Database.FightData.DrawType;

import com.sumo.server.Database.FightData.Draw.Draw;
import com.sumo.server.Database.StaticData.Region.Region;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DRAW_TYPES")
@Getter
@Setter
public class DrawType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DRAW_TYPE_ID")
    private long id;

    @Column(name = "NUMBER_OF_COMPETITORS")
    private int numberOfCompetitors;

    @ManyToOne
    @JoinColumn(name = "REGION")
    private Region region;
}
