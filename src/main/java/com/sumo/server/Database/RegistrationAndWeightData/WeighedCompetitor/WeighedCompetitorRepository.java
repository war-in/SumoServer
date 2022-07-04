package com.sumo.server.Database.RegistrationAndWeightData.WeighedCompetitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeighedCompetitorRepository extends JpaRepository<WeighedCompetitor, Integer> {
    List<WeighedCompetitor> findAllBy();

    WeighedCompetitor findById(Long id);

}
