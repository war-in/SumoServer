package com.sumo.server.Database.StaticData.Country;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findCountryByCountry(String country);
}
