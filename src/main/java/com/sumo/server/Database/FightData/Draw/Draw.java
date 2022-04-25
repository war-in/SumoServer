package com.sumo.server.Database.FightData.Draw;

import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.FightData.CompetitorInDraw.CompetitorInDraw;
import com.sumo.server.Database.FightData.DrawType.DrawType;
import com.sumo.server.Database.FightData.Fight.Fight;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DRAWS")
@Getter
@Setter
public class Draw {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DRAW_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_AT_COMPETITION_ID")
    private CategoryAtCompetition categoryAtCompetition;

    @ManyToOne
    @JoinColumn(name = "DRAW_TYPE_ID")
    private DrawType drawType;

    @OneToMany(mappedBy = "draw")
    private Set<CompetitorInDraw> competitorsInDraw = new LinkedHashSet<>();

    @OneToMany(mappedBy = "draw")
    private Set<Fight> fights = new LinkedHashSet<>();
}
