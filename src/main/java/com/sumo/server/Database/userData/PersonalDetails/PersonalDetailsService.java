package com.sumo.server.Database.userData.PersonalDetails;

import java.util.List;

public interface PersonalDetailsService {
    List<PersonalDetails> getAllByNameAndSurname(String name, String surname);

    PersonalDetails save(PersonalDetails personalDetails);

    PersonalDetails updateLinkToProfilePicture(long id, String link);

    List<PersonalDetails> getAllPersonalDetailsInCountry(String country);
}
