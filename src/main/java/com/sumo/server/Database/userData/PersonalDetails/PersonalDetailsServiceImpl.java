package com.sumo.server.Database.userData.PersonalDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

    final PersonalDetailsRepository personalDetailsRepository;

    @Override
    public List<PersonalDetails> getAllByNameAndSurname(String name, String surname) {
        return personalDetailsRepository.getAllByNameAndSurname(name, surname);
    }

    @Override
    public PersonalDetails updateLinkToProfilePicture(long id, String link) {
        PersonalDetails personalDetails = personalDetailsRepository.findPersonalDetailsById(id);
        personalDetails.setLinkToProfilePicture(link);
        return personalDetailsRepository.save(personalDetails);
    }
}
