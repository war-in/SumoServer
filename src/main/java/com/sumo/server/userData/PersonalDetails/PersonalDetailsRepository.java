package com.sumo.server.userData.PersonalDetails;

import com.sumo.server.userData.PersonalDetails.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    List<PersonalDetails> findAll();
    PersonalDetails getById(Long id);

}
