package com.sumo.server.Database.StaticData.Sex;

import com.sumo.server.Database.StaticData.Sex.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SexRepository extends JpaRepository<Sex,Long>{
    List<Sex> getAllBy();
}
