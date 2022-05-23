package com.sumo.server.Database.CoachData.Coach;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Coach findCoachById(Long id);

    Coach findCoachByPersonalDetails(PersonalDetails personalDetails);
}
