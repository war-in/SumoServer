package com.sumo.server.Database.CoachData.ClubMembershipOfCoach;

import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.TeamData.Club.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubMembershipOfCoachRepository extends JpaRepository<ClubMembershipOfCoach, Long> {
    List<ClubMembershipOfCoach> getClubMembershipOfCoachByCoach(Coach coach);
}
