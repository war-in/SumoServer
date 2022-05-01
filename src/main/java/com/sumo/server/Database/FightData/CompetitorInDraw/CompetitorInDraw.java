package com.sumo.server.Database.FightData.CompetitorInDraw;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.FightData.Draw.Draw;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMPETITORS_IN_DRAWS")
@Getter
@Setter
public class CompetitorInDraw {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITOR_IN_DRAW_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_ID")
    private Competitor competitor;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;
}
