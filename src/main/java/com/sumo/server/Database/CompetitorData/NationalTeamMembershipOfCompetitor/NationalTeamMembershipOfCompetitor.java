package com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitorData.Competitor.Competitor;
import com.sumo.server.Database.TeamData.NationalTeam.NationalTeam;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NATIONAL_TEAM_MEMBERSHIPS_OF_COMPETITORS")
@Getter
@Setter
public class NationalTeamMembershipOfCompetitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NATIONAL_TEAM_MEMBERSHIP_OF_COMPETITOR_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "NATIONAL_TEAM_ID")
    private NationalTeam nationalTeam;

    @ManyToOne
    @JoinColumn(name = "COMPETITOR_ID")
    private Competitor competitor;

    @Column(name = "MEMBERSHIP_START")
    private LocalDate membershipStart;

    @Column(name = "MEMBERSHIP_END")
    private LocalDate membershipEnd;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}
