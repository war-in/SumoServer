package com.sumo.server.Database.FightData.Fight;

import java.util.List;

public interface FightService {
    List<Fight> getAllFights();

    void saveFight(Fight fight);
}
