package com.sumo.server.Database.FightData.Fight;

import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.FightData.Draw.Draw;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FIGHTS")
@Getter
@Setter
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FIGHT_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRAW_ID")
    private Draw draw;

    @ManyToOne
    @JoinColumn(name = "FIRST_COMPETITOR_ID")
    private Competitor firstCompetitor;

    @ManyToOne
    @JoinColumn(name = "SECOND_COMPETITOR_ID")
    private Competitor secondCompetitor;

    @Column(name = "WINNER")
    private boolean winner;

    @Column(name = "NUMBER_OF_PLACE_IN_DRAW")
    private int numberOfPlaceInDraw;
}
