package com.sumo.server.Database.CompetitorData.Competitor;

import com.sumo.server.Database.CompetitorData.ClubMembershipOfCompetitor.ClubMembershipOfCompetitor;
import com.sumo.server.Database.CompetitorData.NationalTeamMembershipOfCompetitor.NationalTeamMembershipOfCompetitor;
import com.sumo.server.Database.FightData.CompetitorInDraw.CompetitorInDraw;
import com.sumo.server.Database.FightData.Fight.Fight;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamCoach.CompetitorRegistrationByNationalTeamCoach;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "COMPETITORS")
@Getter
@Setter
public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITOR_ID")
    private long id;

    @OneToOne(mappedBy = "competitor")
    private PersonalData personalData;

    @OneToMany(mappedBy = "competitor")
    private Set<ClubMembershipOfCompetitor> clubMembershipsOfCompetitor = new LinkedHashSet<>();

    @OneToMany(mappedBy = "competitor")
    private Set<NationalTeamMembershipOfCompetitor> nationalTeamMembershipsOfCompetitor = new LinkedHashSet<>();

    @OneToMany(mappedBy = "competitor")
    private Set<CompetitorInDraw> competitorInDraws = new LinkedHashSet<>();

    @OneToMany(mappedBy = "firstCompetitor")
    private Set<Fight> fightsAsFirstCompetitor = new LinkedHashSet<>();

    @OneToMany(mappedBy = "secondCompetitor")
    private Set<Fight> fightsAsSecondCompetitor = new LinkedHashSet<>();

    @OneToMany(mappedBy = "competitor")
    private Set<CompetitorRegistrationByNationalTeamCoach> registrationsByNationalTeamCoach = new LinkedHashSet<>();

    @OneToMany(mappedBy = "competitor")
    private Set<CompetitorRegistrationByNationalTeamAdmin> registrationsByNationalTeamAdmin = new LinkedHashSet<>();
}
