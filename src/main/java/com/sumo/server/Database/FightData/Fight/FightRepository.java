package com.sumo.server.Database.FightData.Fight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FightRepository extends JpaRepository<Fight, Integer> {

    Fight findById(Long id);
}
