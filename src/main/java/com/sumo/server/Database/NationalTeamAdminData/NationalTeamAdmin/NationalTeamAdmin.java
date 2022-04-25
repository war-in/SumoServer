package com.sumo.server.Database.NationalTeamAdminData.NationalTeamAdmin;

import com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach.NationalTeamMembershipOfCoach;
import com.sumo.server.Database.NationalTeamAdminData.NationalTeamMembershipOfAdmin.NationalTeamMembershipOfAdmin;
import com.sumo.server.Database.RegistrationAndWeightData.CompetitorRegistrationByNationalTeamAdmin.CompetitorRegistrationByNationalTeamAdmin;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "NATIONAL_TEAMS_ADMINS")
@Getter
@Setter
public class NationalTeamAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NATIONAL_TEAM_ADMIN_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;

    @OneToMany(mappedBy = "nationalTeamAdmin")
    private Set<NationalTeamMembershipOfAdmin> nationalTeamMembershipsOfAdmin = new LinkedHashSet<>();

    @OneToMany(mappedBy = "nationalTeamAdmin")
    private Set<CompetitorRegistrationByNationalTeamAdmin> competitorRegistrations = new LinkedHashSet<>();
}
