package com.sumo.server.Database.userData.PersonalDetails;

import java.util.List;

public interface PersonalDetailsService {
    List<PersonalDetails> getAllByNameAndSurname(String name, String surname);

    PersonalDetails updateLinkToProfilePicture(long id, String link);
}
