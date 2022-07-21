package com.sumo.server.Database.CoachData.Coach;

import com.sumo.server.Database.CoachData.ClubMembershipOfCoach.ClubMembershipOfCoach;
import com.sumo.server.Database.CoachData.ClubMembershipOfCoach.ClubMembershipOfCoachRepository;
import com.sumo.server.Database.TeamData.Club.Club;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CoachServiceImpl implements CoachService {

    final CoachRepository coachRepository;
    final ClubMembershipOfCoachRepository clubMembershipOfCoachRepository;
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
    @Override
    public Coach getCoachesByPersonalDetails(PersonalDetails personalDetails){
        return coachRepository.findCoachByPersonalDetails(personalDetails);
    };


    @Override
    public List<Club> getClubAdministeredByCoach(Coach coach) {
        ChronoLocalDate actualDate = ChronoLocalDate.from(Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime());

        return clubMembershipOfCoachRepository.getClubMembershipOfCoachByCoach(coach).stream()
            .filter(membership -> (membership.getMembershipEnd() == null || (membership.getMembershipEnd().isAfter(actualDate) && membership.getMembershipStart().isBefore(actualDate))))
            .map(ClubMembershipOfCoach::getClub).toList();
    }
}
