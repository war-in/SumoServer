package com.sumo.server.Database.userData.PersonalDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    List<PersonalDetails> findAll();
    PersonalDetails getById(Long id);
    List<PersonalDetails> getAllByNameAndSurname(String name, String surname);

}
