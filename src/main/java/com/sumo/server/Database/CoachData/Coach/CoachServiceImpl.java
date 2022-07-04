package com.sumo.server.Database.CoachData.Coach;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CoachServiceImpl implements CoachService {

    final CoachRepository coachRepository;
    final PersonalDetailsRepository personalDetailsRepository;

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public List<Coach> getCoachesByPersonalDetails(List<PersonalDetails> personalDetails) {
        List<Coach> coaches = new ArrayList<>();

        for (PersonalDetails personalDetails1 : personalDetails) {
            coaches.add(coachRepository.findCoachByPersonalDetails(personalDetails1));
        }
        return coaches;
    }

    @Override
    public Coach save(Coach coach) {
        Coach result = null;
        PersonalDetails personalDetails = personalDetailsRepository.findPersonalDetailsById(coach.getPersonalDetails().getId());
        coach.setPersonalDetails(personalDetails);

        try {
            result = coachRepository.save(coach);
        } catch (Exception error) {
            log.error(error.getMessage());
        }
        return result;
    }
}
