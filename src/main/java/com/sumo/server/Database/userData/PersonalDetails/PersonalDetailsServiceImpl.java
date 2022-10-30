package com.sumo.server.Database.userData.PersonalDetails;

import com.sumo.server.Database.StaticData.Country.Country;
import com.sumo.server.Database.StaticData.Country.CountryRepository;
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
    final CountryRepository countryRepository;

    @Override
    public List<PersonalDetails> getAllByNameAndSurname(String name, String surname) {
        return personalDetailsRepository.getAllByNameAndSurname(name, surname);
    }

    @Override
    public PersonalDetails save(PersonalDetails personalDetails) {
        return personalDetailsRepository.save(personalDetails);
    }
    @Override
    public PersonalDetails updateLinkToProfilePicture(long id, String link) {
        PersonalDetails personalDetails = personalDetailsRepository.findPersonalDetailsById(id);
        personalDetails.setLinkToProfilePicture(link);
        return personalDetailsRepository.save(personalDetails);
    }

    @Override
    public List<PersonalDetails> getAllPersonalDetailsInCountry(String country) {
        Country countryFromDb = countryRepository.findCountryByCountry(country);
        return personalDetailsRepository.getAllByCountry(countryFromDb);
    }
}
