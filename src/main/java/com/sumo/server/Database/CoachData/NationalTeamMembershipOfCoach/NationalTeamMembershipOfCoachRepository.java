package com.sumo.server.Database.CoachData.NationalTeamMembershipOfCoach;

import com.sumo.server.Database.CoachData.ClubMembershipOfCoach.ClubMembershipOfCoach;
import com.sumo.server.Database.CoachData.Coach.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationalTeamMembershipOfCoachRepository extends JpaRepository<NationalTeamMembershipOfCoach, Long> {
    List<NationalTeamMembershipOfCoach> getNationalTeamMembershipOfCoachByCoach(Coach coach);
}
