package com.sumo.server.Database.CompetitionData.Competition;

import com.sumo.server.Database.StaticData.City.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Integer> {

    List<Competition> findAllBy();

    List<Competition> findCompetitionsByName(String name);

    Competition findById(Long id);

    Competition findCompetitionByCityAndStartDateAndEndDateAndName(City city, LocalDate startDate, LocalDate endDate, String name);

    Competition removeById(Long id);

    Long deleteById(Long id);

}
