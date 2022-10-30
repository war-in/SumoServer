package com.sumo.server.Database.userData.PersonalDetails;

import com.sumo.server.Database.StaticData.Country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    PersonalDetails findPersonalDetailsById(Long id);

    List<PersonalDetails> getAllByNameAndSurname(String name, String surname);

    List<PersonalDetails> getAllByCountry(Country country);
}
