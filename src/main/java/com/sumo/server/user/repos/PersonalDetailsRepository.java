package com.sumo.server.user.repos;

import com.sumo.server.user.entities.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    List<PersonalDetails> findAll();

}
